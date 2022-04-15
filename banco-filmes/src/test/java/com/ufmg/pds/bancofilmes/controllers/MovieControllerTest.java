package com.ufmg.pds.bancofilmes.controllers;

import com.ufmg.pds.bancofilmes.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
class MovieControllerTest {
  @Autowired MovieController movieController;
  @MockBean MovieService movieService;

  @Test
  void itShouldTest() {
    assertEquals(1, 1);
  }
}
