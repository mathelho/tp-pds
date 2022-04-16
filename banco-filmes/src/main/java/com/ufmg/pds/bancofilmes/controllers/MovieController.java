package com.ufmg.pds.bancofilmes.controllers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.services.MovieServiceWithoutDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
  private final MovieServiceWithoutDB movieService = new MovieServiceWithoutDB();

  @GetMapping
  public ResponseEntity<List<Movie>> listAll() {
    return ResponseEntity.ok(movieService.listAll());
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
  public ResponseEntity<Movie> save(@RequestBody Movie movie) {
    return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    movieService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody Movie movie) {
    movieService.replace(movie);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
