package com.ufmg.pds.bancofilmes.controllers;

import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMovie;
import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMoviePostRequestBody;
import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createRateMoviePostRequestBody;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.repositories.MovieRepository;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MovieControllerIntegrationTest {
  @Autowired private TestRestTemplate testRestTemplate;
  @Autowired private MovieRepository movieRepository;

  private static final String MOVIE_ENDPOINT = "/movies";
  private static final String MOVIE_ENDPOINT_RATE = "/movies/rate";

  @Test
  void itShouldReturnAllMoviesSavedOnDataBaseSuccessfully() {
    // given:
    Movie savedMovie = movieRepository.save(createMovie());
    String expectedTitle = savedMovie.getTitle();

    // when:
    List<Movie> movies =
        testRestTemplate
            .exchange(
                MOVIE_ENDPOINT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {})
            .getBody();

    // then:
    assertTrue(ObjectUtils.isNotEmpty(movies));
    assertEquals(1, movies.size());
    assertEquals(expectedTitle, movies.get(0).getTitle());
  }

  @Test
  void itShouldSaveAMovieInDataBaseSuccessfully() {
    // given:
    MoviePostRequestBodyDTO moviePostRequestBodyDTO = createMoviePostRequestBody();
    String expectedTitle = moviePostRequestBodyDTO.getTitle();

    // when:
    ResponseEntity<Movie> movieResponseEntity =
        testRestTemplate.postForEntity(MOVIE_ENDPOINT, moviePostRequestBodyDTO, Movie.class);

    // then:
    assertTrue(ObjectUtils.isNotEmpty(movieResponseEntity));
    assertEquals(HttpStatus.CREATED, movieResponseEntity.getStatusCode());

    assertTrue(ObjectUtils.isNotEmpty(movieResponseEntity.getBody()));
    assertEquals(expectedTitle, movieResponseEntity.getBody().getTitle());
  }

  @Test
  void itShouldRateAMovieSuccessfully() {
    // given:
    Movie savedMovie = movieRepository.save(createMovie());
    Double score = 9.5;

    RateMoviePostRequestBodyDTO rateMoviePostRequestBodyDTO = createRateMoviePostRequestBody(score);

    // when:
    ResponseEntity<Movie> movieResponseEntity =
        testRestTemplate.postForEntity(
            MOVIE_ENDPOINT_RATE, rateMoviePostRequestBodyDTO, Movie.class);

    // then:
    assertTrue(ObjectUtils.isNotEmpty(movieResponseEntity));
    assertEquals(HttpStatus.OK, movieResponseEntity.getStatusCode());

    assertTrue(ObjectUtils.isNotEmpty(movieResponseEntity.getBody()));
    assertEquals(savedMovie.getTitle(), movieResponseEntity.getBody().getTitle());

    assertEquals(1, movieResponseEntity.getBody().getNumberOfReviews());
    assertEquals(score, movieResponseEntity.getBody().getScore());
  }
}
