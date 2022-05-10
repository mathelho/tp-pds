package com.ufmg.pds.bancofilmes.domains.ports.interfaces;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import java.util.List;

public interface MovieServicePort {
  List<Movie> listAll();

  Movie findById(Long id);

  Movie findByName(String name);

  // @Transactional
  Movie save(MoviePostRequestBodyDTO movie);

  void delete(Long id);

  void replace(MoviePutRequestBodyDTO movie);
}
