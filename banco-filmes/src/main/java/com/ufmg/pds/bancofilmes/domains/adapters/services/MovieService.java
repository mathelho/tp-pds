package com.ufmg.pds.bancofilmes.domains.adapters.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort;
import com.ufmg.pds.bancofilmes.exceptions.NotFoundException;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import com.ufmg.pds.bancofilmes.mapper.MovieMapper;
import java.util.List;

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
  public Movie findByName(String name) {
    return movieRepositoryPort
        .findByName(name)
        .orElseThrow(() -> new NotFoundException(String.format("Movie %s not found", name)));
  }

  @Override
  public Movie save(MoviePostRequestBodyDTO movie) {
    return movieRepositoryPort.save(MovieMapper.INSTANCE.toMovie(movie));
  }

  @Override
  public void delete(Long id) {
    movieRepositoryPort.delete(findById(id));
  }

  @Override
  public void replace(MoviePutRequestBodyDTO movie) {
    Movie savedMovie = findById(movie.getId());
    movie.setId(savedMovie.getId());
    // TODO a mapper here
    MovieEntity replaceMovie = new MovieEntity();
    replaceMovie.setId(savedMovie.getId());
    springMovieRepository.save(replaceMovie);
  }
}
