package com.ufmg.pds.bancofilmes.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufmg.pds.bancofilmes.adapters.controllers.MovieController;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

  private static final String ENDPOINT_MOVIES = "/movies";
  private static final String ENDPOINT_MOVIES_ID = "/movies/{id}";
  private static final String ENDPOINT_MOVIES_FIND = "/movies/find";
  private static final String ENDPOINT_MOVIES_TOP = "/movies/top";
  private static final String ENDPOINT_MOVIES_RATE = "/movies/rate";
  private static final String ENDPOINT_MOVIES_BATCH = "/movies/batch";
  private static final String ENDPOINT_MOVIES_CLEAR = "/movies/clear";
  @Autowired MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;
  @MockBean MovieServicePort movieService;

  @Test
  void itShouldTestTheGETEndpointMoviesSuccessfully() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_MOVIES)).andExpect(status().isOk());
  }

  @Test
  void itShouldTestTheGETEndpointMoviesIdSuccessfully() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_MOVIES_ID, 1L)).andExpect(status().isOk());
  }

  @Test
  void itShouldTestTheGETEndpointMoviesFindSuccessfully() throws Exception {
    LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    requestParams.add("title", "movie-title");
    mockMvc
        .perform(MockMvcRequestBuilders.get(ENDPOINT_MOVIES_FIND).params(requestParams))
        .andExpect(status().isOk());
  }

  @Test
  void itShouldTestTheGETEndpointMoviesTopSuccessfully() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_MOVIES_TOP)).andExpect(status().isOk());
  }

  @Test
  void itShouldTestThePOSTEndpointMoviesSuccessfully() throws Exception {
    MoviePostRequestBodyDTO moviePostRequestBodyDTO = new MoviePostRequestBodyDTO();
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(ENDPOINT_MOVIES)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moviePostRequestBodyDTO)))
        .andExpect(status().isCreated());
  }

  @Test
  void itShouldTestThePOSTEndpointMoviesRateSuccessfully() throws Exception {
    RateMoviePostRequestBodyDTO rateMoviePostRequestBodyDTO = new RateMoviePostRequestBodyDTO();
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(ENDPOINT_MOVIES_RATE)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rateMoviePostRequestBodyDTO)))
        .andExpect(status().isOk());
  }

  @Test
  void itShouldTestThePOSTEndpointMoviesBatchSuccessfully() throws Exception {
    List<MoviePostRequestBodyDTO> moviePostRequestBodyDTOs = new ArrayList<>();
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(ENDPOINT_MOVIES_BATCH)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moviePostRequestBodyDTOs)))
        .andExpect(status().isCreated());
  }

  @Test
  void itShouldTestTheDELETEEndpointMovieSuccessfully() throws Exception {
    LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    requestParams.add("id", "1");

    mockMvc
        .perform(
            MockMvcRequestBuilders.delete(ENDPOINT_MOVIES, 1L)
                .contentType(APPLICATION_JSON)
                .params(requestParams))
        .andExpect(status().isNoContent());
  }

  @Test
  void itShouldTestTheDELETEEndpointMoviesClearSuccessfully() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.delete(ENDPOINT_MOVIES_CLEAR))
        .andExpect(status().isNoContent());
  }

  @Test
  void itShouldTestThePUTEndpointMoviesSuccessfully() throws Exception {
    MoviePutRequestBodyDTO moviePutRequestBodyDTO = new MoviePutRequestBodyDTO();
    mockMvc
        .perform(
            MockMvcRequestBuilders.put(ENDPOINT_MOVIES)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moviePutRequestBodyDTO)))
        .andExpect(status().isNoContent());
  }
}
