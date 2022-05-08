package com.ufmg.pds.bancofilmes.adapters.controllers;

import com.ufmg.pds.bancofilmes.domains.dtos.MovieDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
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

  private final MovieServicePort movieService;

  public MovieController(MovieServicePort movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<MovieDTO>> findAll() {
    return ResponseEntity.ok(movieService.listAll());
  }

  @GetMapping(path = "/find")
  public ResponseEntity<MovieDTO> findByName(@RequestParam String name) {
    return ResponseEntity.ok(movieService.findByName(name));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
    return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MovieDTO> save(@RequestBody MoviePostRequestBodyDTO movie) {
    return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    movieService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody MoviePutRequestBodyDTO movie) {
    movieService.replace(movie);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
