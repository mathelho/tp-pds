package com.ufmg.pds.bancofilmes.domains.ports.repositories;

import com.ufmg.pds.bancofilmes.domains.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepositoryPort {
  List<Movie> findAll();

  Optional<Movie> findById(Long id);

  Optional<Movie> findByName(String name);

  Movie save(Movie movie);

  void delete(Movie movie);

  void replace(Movie movie);
}
