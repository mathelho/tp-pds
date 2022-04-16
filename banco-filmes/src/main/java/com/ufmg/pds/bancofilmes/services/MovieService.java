package com.ufmg.pds.bancofilmes.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.repositories.MovieRepository;
import com.ufmg.pds.bancofilmes.requests.MoviePostRequestBody;
import com.ufmg.pds.bancofilmes.requests.MoviePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found"));
  }

  public Movie findByName(String name) {
    return movieRepository
        .findByName(name)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
  }

  public Movie save(MoviePostRequestBody moviePostRequestBody) {
    Movie movie =
        new Movie(
            moviePostRequestBody.getName(),
            moviePostRequestBody.getDirector(),
            moviePostRequestBody.getScore());
    return movieRepository.save(movie);
  }

  public void delete(Long id) {
    movieRepository.delete(findById(id));
  }

  public void replace(MoviePutRequestBody moviePutRequestBody) {
    Movie savedMovie = findById(moviePutRequestBody.getId());

    Movie movie =
        new Movie(
            savedMovie.getId(),
            moviePutRequestBody.getName(),
            moviePutRequestBody.getDirector(),
            moviePutRequestBody.getScore());

    movieRepository.save(movie);
  }
}
