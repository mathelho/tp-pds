package com.ufmg.pds.bancofilmes.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MovieService {
  // private final MovieRepository movieRepository;

  private static final List<Movie> movies;

  static {
    movies =
        new ArrayList<>(
            Arrays.asList(
                new Movie(1L, "Interstellar", "Christopher Nolan", 9.0),
                new Movie(2L, "Batman Begins", "Christopher Nolan", 8.8)));
  }

  public List<Movie> listAll() {
    return movies;
  }

  public Movie findById(Long id) {
    return movies.stream()
        .filter(movie -> movie.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found"));
  }

  public Movie findByName(String name) {
    return movies.stream()
        .filter(movie -> movie.getName().equals(name))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
  }

  public Movie save(Movie movie) {
    movie.setId(ThreadLocalRandom.current().nextLong(3, 99999));
    movies.add(movie);
    return movie;
  }

  public void delete(Long id) {
    movies.remove(findById(id));
  }

  public void replace(Movie movie) {
    delete(movie.getId());
    movies.add(movie);
  }
}
