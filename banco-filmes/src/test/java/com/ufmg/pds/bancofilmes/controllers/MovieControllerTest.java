package com.ufmg.pds.bancofilmes.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ufmg.pds.bancofilmes.adapters.controllers.MovieController;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

  private static final String ENDPOINT_MOVIES = "/movies";
  @Autowired MockMvc mockMvc;
  @MockBean MovieServicePort movieService;

  @Test
  void itShouldTestTheGETEndpointMoviesSuccessfully() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_MOVIES)).andExpect(status().isOk());
  }
}
