package com.ufmg.pds.bancofilmes.adapters.controllers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequestMapping("movies")
public class MovieController {

  private final MovieServicePort movieService;

  public MovieController(MovieServicePort movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<Movie>> findAll() {
    return ResponseEntity.ok(movieService.listAll());
  }

  @GetMapping(path = "/find")
  public ResponseEntity<Movie> findByTitle(@RequestParam String title) {
    return ResponseEntity.ok(movieService.findByTitle(title));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Movie> findById(@PathVariable Long id) {
    return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
  }

  @GetMapping(path = "/top")
  public ResponseEntity<List<Movie>> getTop() {
    return ResponseEntity.ok(movieService.getTopTen());
  }

  @PostMapping
  public ResponseEntity<Movie> save(@RequestBody MoviePostRequestBodyDTO movie) {
    return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
  }

  @PostMapping(path = "/rate")
  public ResponseEntity<Movie> rate(@RequestBody RateMoviePostRequestBodyDTO score) {
    return new ResponseEntity<>(movieService.rate(score), HttpStatus.OK);
  }

  @PostMapping(path = "/batch")
  public ResponseEntity<List<Movie>> saveInBatch(
      @RequestBody List<MoviePostRequestBodyDTO> movies) {
    return new ResponseEntity<>(movieService.saveInBatch(movies), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<Void> delete(@RequestParam Long id) {
    movieService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(path = "/clear")
  public ResponseEntity<Void> clear() {
    movieService.clear();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody MoviePutRequestBodyDTO movie) {
    movieService.replace(movie);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
