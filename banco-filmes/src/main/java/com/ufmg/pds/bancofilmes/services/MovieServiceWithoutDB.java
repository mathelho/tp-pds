package com.ufmg.pds.bancofilmes.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.requests.MoviePostRequestBody;
import com.ufmg.pds.bancofilmes.requests.MoviePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MovieServiceWithoutDB {
  private static final List<Movie> movies;

  static {
    movies =
        new ArrayList<>(
            Arrays.asList(
                new Movie(1L, "Interstellar", "Christopher Nolan", 9.0),
                new Movie(2L, "Batman Begins", "Christopher Nolan", 8.8)));
  }

  public List<Movie> findAll() {
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

  public Movie save(MoviePostRequestBody moviePostRequestBody) {
    Movie movie =
        new Movie(
            ThreadLocalRandom.current().nextLong(3, 99999),
            moviePostRequestBody.getName(),
            moviePostRequestBody.getDirector(),
            moviePostRequestBody.getScore());
    movies.add(movie);

    return movie;
  }

  public void delete(Long id) {
    movies.remove(findById(id));
  }

  public void replace(MoviePutRequestBody moviePutRequestBody) {
    delete(moviePutRequestBody.getId());

    Movie movie =
        new Movie(
            moviePutRequestBody.getId(),
            moviePutRequestBody.getName(),
            moviePutRequestBody.getDirector(),
            moviePutRequestBody.getScore());
    movies.add(movie);
  }
}
