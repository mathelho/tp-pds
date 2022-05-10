package com.ufmg.pds.bancofilmes.infrastructure.adapters.repositories;

import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringMovieRepository extends JpaRepository<MovieEntity, Long> {
  Optional<MovieEntity> findByName(String name);
}
