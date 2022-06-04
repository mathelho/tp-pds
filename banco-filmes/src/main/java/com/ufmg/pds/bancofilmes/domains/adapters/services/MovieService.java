package com.ufmg.pds.bancofilmes.domains.adapters.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.mappers.MovieMapper;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort;
import com.ufmg.pds.bancofilmes.exceptions.BadRequestException;
import com.ufmg.pds.bancofilmes.exceptions.NotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.lang3.ObjectUtils;

public class MovieService implements MovieServicePort {
  private final MovieRepositoryPort movieRepositoryPort;

  public MovieService(MovieRepositoryPort movieRepositoryPort) {
    this.movieRepositoryPort = movieRepositoryPort;
  }

  @Override
  public List<Movie> listAll() {
    return movieRepositoryPort.findAll();
  }

  @Override
  public Movie findById(Long id) {
    return movieRepositoryPort
        .findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Movie with id %d not found", id)));
  }

  @Override
  public Movie findByTitle(String title) {
    return movieRepositoryPort
        .findByTitle(title)
        .orElseThrow(() -> new NotFoundException(String.format("Movie %s not found", title)));
  }

  @Override
  @Transactional
  public Movie save(MoviePostRequestBodyDTO movie) {
    Movie movieToBeSaved = MovieMapper.INSTANCE.toMovie(movie);
    movieToBeSaved.setNumberOfReviews(0);
    movieToBeSaved.setScore(0.0);
    return movieRepositoryPort.save(movieToBeSaved);
  }

  @Override
  public Movie rate(RateMoviePostRequestBodyDTO rate) {
    Movie savedMovie = findById(rate.getId());

    if (ObjectUtils.isEmpty(rate.getScore()) || rate.getScore() > 10.0 || rate.getScore() < 1.0) {
      throw new BadRequestException("Movie score should be between 1 and 10");
    }

    Integer actualReviewers = savedMovie.getNumberOfReviews();
    Double actualScore = savedMovie.getScore();
    savedMovie.setNumberOfReviews(actualReviewers + 1);

    BigDecimal newScore =
        BigDecimal.valueOf(
                (actualReviewers * actualScore + rate.getScore()) / savedMovie.getNumberOfReviews())
            .setScale(1, RoundingMode.HALF_UP);

    savedMovie.setScore(newScore.doubleValue());

    return movieRepositoryPort.save(savedMovie);
  }

  @Override
  public void delete(Long id) {
    movieRepositoryPort.delete(findById(id));
  }

  @Override
  public void replace(MoviePutRequestBodyDTO movie) {
    Movie savedMovie = findById(movie.getId());

    Movie movieToBeSaved = MovieMapper.INSTANCE.toMovie(movie);
    movieToBeSaved.setId(savedMovie.getId());
    movieToBeSaved.setNumberOfReviews(savedMovie.getNumberOfReviews());
    movieToBeSaved.setScore(savedMovie.getScore());

    movieRepositoryPort.save(movieToBeSaved);
  }

  @Override
  public List<Movie> getTopTen() {
    return movieRepositoryPort.getTopTen();
  }
}
