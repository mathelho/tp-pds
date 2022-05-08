package com.ufmg.pds.bancofilmes.infrastructure.adapters.repositories;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import com.ufmg.pds.bancofilmes.mapper.MovieMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MovieRepository implements MovieRepositoryPort {
  private final SpringMovieRepository springMovieRepository;

  public MovieRepository(final SpringMovieRepository springMovieRepository) {
    this.springMovieRepository = springMovieRepository;
  }

  @Override
  public List<Movie> findAll() {
    List<MovieEntity> allMovies = springMovieRepository.findAll();
    return allMovies.stream().map(MovieMapper.INSTANCE::toMovie).toList();
  }

  @Override
  public Optional<Movie> findById(Long id) {
    Optional<MovieEntity> movie = springMovieRepository.findById(id);
    return movie.isEmpty() ? ;
  }

  @Override
  public Optional<Movie> findByName(String name) {
    return springMovieRepository.findByName(name);
  }

  @Override
  public Movie save(Movie movie) {
    MovieEntity savedMovie = springMovieRepository.save(MovieMapper.INSTANCE.toMovieEntity(movie));
    return MovieMapper.INSTANCE.toMovie(savedMovie);
  }

  @Override
  public void delete(Movie movie) {
    springMovieRepository.delete(MovieMapper.INSTANCE.toMovieEntity(movie));
  }

  @Override
  public void replace(Movie movie) {
    springMovieRepository.save(MovieMapper.INSTANCE.toMovieEntity(movie));
  }
}
