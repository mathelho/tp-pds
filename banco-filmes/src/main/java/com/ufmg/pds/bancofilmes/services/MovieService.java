package com.ufmg.pds.bancofilmes.services;

import com.ufmg.pds.bancofilmes.domains.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
  // private final MovieRepository movieRepository;
  public List<Movie> listAll() {
    return List.of(
        new Movie(1L, "Interstellar", "Christopher Nolan", 9.0),
        new Movie(2L, "Batman Begins", "Christopher Nolan", 8.8));
  }
}
