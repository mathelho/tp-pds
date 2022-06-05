package com.ufmg.pds.bancofilmes.domains.ports.interfaces;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import java.util.List;

public interface MovieServicePort {
  List<Movie> listAll();

  Movie findById(Long id);

  Movie findByTitle(String title);

  Movie save(MoviePostRequestBodyDTO movie);

  Movie rate(RateMoviePostRequestBodyDTO rate);

  List<Movie> saveInBatch(List<MoviePostRequestBodyDTO> movies);

  void delete(Long id);

  void clear();

  void replace(MoviePutRequestBodyDTO movie);

  List<Movie> getTopTen();
}
