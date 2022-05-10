// package com.ufmg.pds.bancofilmes.services;
//
// import com.ufmg.pds.bancofilmes.domains.Movie;
// import com.ufmg.pds.bancofilmes.mapper.MovieMapper;
// import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
// import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.concurrent.ThreadLocalRandom;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;
//
// @Service
// public class MovieServiceWithoutDB {
//  private static final List<Movie> movies;
//
//  static {
//    movies =
//        new ArrayList<>(
//            Arrays.asList(
//                new Movie(1L, "Interstellar", "Christopher Nolan", 9.0),
//                new Movie(2L, "Batman Begins", "Christopher Nolan", 8.8)));
//  }
//
//  public List<Movie> findAll() {
//    return movies;
//  }
//
//  public Movie findById(Long id) {
//    return movies.stream()
//        .filter(movie -> movie.getId().equals(id))
//        .findFirst()
//        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not
// found"));
//  }
//
//  public Movie findByName(String name) {
//    return movies.stream()
//        .filter(movie -> movie.getName().equals(name))
//        .findFirst()
//        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
//  }
//
//  public Movie save(MoviePostRequestBodyDTO moviePostRequestBodyDTO) {
//    Movie movie = MovieMapper.INSTANCE.toMovie(moviePostRequestBodyDTO);
//    movie.setId(ThreadLocalRandom.current().nextLong(3, 99999));
//    movies.add(movie);
//
//    return movie;
//  }
//
//  public void delete(Long id) {
//    movies.remove(findById(id));
//  }
//
//  public void replace(MoviePutRequestBodyDTO moviePutRequestBodyDTO) {
//    delete(moviePutRequestBodyDTO.getId());
//    movies.add(MovieMapper.INSTANCE.toMovie(moviePutRequestBodyDTO));
//  }
// }
