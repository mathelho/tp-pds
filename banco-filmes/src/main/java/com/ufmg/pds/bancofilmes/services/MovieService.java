package com.ufmg.pds.bancofilmes.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.exceptions.NotFoundException;
import com.ufmg.pds.bancofilmes.mapper.MovieMapper;
import com.ufmg.pds.bancofilmes.repositories.MovieRepository;
import com.ufmg.pds.bancofilmes.requests.MoviePostRequestBody;
import com.ufmg.pds.bancofilmes.requests.MoviePutRequestBody;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  public Movie findById(Long id) {
    return movieRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Movie with id %d not found", id)));
  }

  public Movie findByName(String name) {
    return movieRepository
        .findByName(name)
        .orElseThrow(() -> new NotFoundException(String.format("Movie %s not found", name)));
  }

  public Movie save(MoviePostRequestBody moviePostRequestBody) {
    return movieRepository.save(MovieMapper.INSTANCE.toMovie(moviePostRequestBody));
  }

  public void delete(Long id) {
    movieRepository.delete(findById(id));
  }

  public void replace(MoviePutRequestBody moviePutRequestBody) {
    Movie savedMovie = findById(moviePutRequestBody.getId());

    Movie movie = MovieMapper.INSTANCE.toMovie(moviePutRequestBody);
    movie.setId(savedMovie.getId());

    movieRepository.save(movie);
  }
}
