package com.ufmg.pds.bancofilmes.controllers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
  private final MovieService movieService = new MovieService();

  @GetMapping
  public List<Movie> listAll() {
    return movieService.listAll();
  }
}
