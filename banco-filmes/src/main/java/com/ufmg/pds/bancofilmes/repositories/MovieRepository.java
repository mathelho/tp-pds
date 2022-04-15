package com.ufmg.pds.bancofilmes.repositories;

import com.ufmg.pds.bancofilmes.domains.Movie;

import java.util.List;

public interface MovieRepository {
  List<Movie> listAll();
}
