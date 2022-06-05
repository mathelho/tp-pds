package com.ufmg.pds.bancofilmes.infrastructure.adapters.repositories;

import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringMovieRepository extends JpaRepository<MovieEntity, Long> {
  Optional<MovieEntity> findByTitle(String title);

  @Query(
      value = "SELECT * from movie_entity me ORDER BY me.score DESC LIMIT 10",
      nativeQuery = true)
  List<MovieEntity> getTopTen();

  @Modifying
  @Query(value = "DELETE from movie_entity", nativeQuery = true)
  void clear();
}
