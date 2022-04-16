package com.ufmg.pds.bancofilmes.repositories;

import com.ufmg.pds.bancofilmes.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
