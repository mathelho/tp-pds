package com.ufmg.pds.bancofilmes.infrastructure.configs;

import com.ufmg.pds.bancofilmes.domains.adapters.services.MovieService;
import com.ufmg.pds.bancofilmes.domains.ports.interfaces.MovieServicePort;
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  MovieServicePort movieService(MovieRepositoryPort movieRepositoryPort) {
    return new MovieService(movieRepositoryPort);
  }
}
