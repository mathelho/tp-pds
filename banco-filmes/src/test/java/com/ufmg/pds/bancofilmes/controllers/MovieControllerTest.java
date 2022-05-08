package com.ufmg.pds.bancofilmes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ufmg.pds.bancofilmes.adapters.controllers.MovieController;
import com.ufmg.pds.bancofilmes.services.MovieServiceWithoutDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
class MovieControllerTest {
  @Autowired MovieController movieController;
  @MockBean MovieServiceWithoutDB movieService;

  @Test
  void itShouldTest() {
    assertEquals(1, 1);
  }
}
