// package com.ufmg.pds.bancofilmes.services;
//
// import com.ufmg.pds.bancofilmes.domains.Movie;
// import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
// import com.ufmg.pds.bancofilmes.exceptions.NotFoundException;
// import com.ufmg.pds.bancofilmes.mapper.MovieMapper;
// import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
// import java.util.List;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// @Service
// public class MovieService {
//  private final MovieRepository movieRepository;
//
//  public MovieService(MovieRepository movieRepository) {
//    this.movieRepository = movieRepository;
//  }
//
//  public List<Movie> findAll() {
//    return movieRepository.findAll();
//  }
//
//  public Movie findById(Long id) {
//    return movieRepository
//        .findById(id)
//        .orElseThrow(() -> new NotFoundException(String.format("Movie with id %d not found",
// id)));
//  }
//
//  public Movie findByName(String name) {
//    return movieRepository
//        .findByName(name)
//        .orElseThrow(() -> new NotFoundException(String.format("Movie %s not found", name)));
//  }
//
//  @Transactional
//  public Movie save(MoviePostRequestBodyDTO moviePostRequestBodyDTO) {
//    return movieRepository.save(MovieMapper.INSTANCE.toMovie(moviePostRequestBodyDTO));
//  }
//
//  public void delete(Long id) {
//    movieRepository.delete(findById(id));
//  }
//
//  public void replace(MoviePutRequestBodyDTO moviePutRequestBodyDTO) {
//    Movie savedMovie = findById(moviePutRequestBodyDTO.getId());
//
//    Movie movie = MovieMapper.INSTANCE.toMovie(moviePutRequestBodyDTO);
//    movie.setId(savedMovie.getId());
//
//    movieRepository.save(movie);
//  }
// }
