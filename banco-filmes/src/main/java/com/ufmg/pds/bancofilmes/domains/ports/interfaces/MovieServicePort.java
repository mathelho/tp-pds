package com.ufmg.pds.bancofilmes.domains.ports.interfaces;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import java.util.List;

public interface MovieServicePort {
  public List<Movie> listAll();

  public Movie findById(Long id);

  public Movie findByName(String name);

  // @Transactional
  public Movie save(MoviePostRequestBodyDTO movie);

  public void delete(Long id);

  public void replace(MoviePutRequestBodyDTO movie);
}
