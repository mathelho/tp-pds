package com.ufmg.pds.bancofilmes.controllers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.requests.MoviePostRequestBody;
import com.ufmg.pds.bancofilmes.requests.MoviePutRequestBody;
import com.ufmg.pds.bancofilmes.services.MovieService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<Movie>> findAll() {
    return ResponseEntity.ok(movieService.findAll());
  }

  @GetMapping(path = "/find")
  public ResponseEntity<Movie> findByName(@RequestParam String name) {
    return ResponseEntity.ok(movieService.findByName(name));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Movie> findById(@PathVariable Long id) {
    return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Movie> save(@RequestBody MoviePostRequestBody movie) {
    return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    movieService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody MoviePutRequestBody movie) {
    movieService.replace(movie);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
