package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("director")
  private String director;

  @JsonProperty("score")
  private Double score;

  public MovieEntity() {}

  public MovieEntity(Long id, String name, String director, Double score) {
    this.id = id;
    this.name = name;
    this.director = director;
    this.score = score;
  }

  public MovieEntity(String name, String director, Double score) {
    this.name = name;
    this.director = director;
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MovieEntity that = (MovieEntity) o;

    if (!Objects.equals(id, that.id)) {
      return false;
    }
    if (!Objects.equals(name, that.name)) {
      return false;
    }
    if (!Objects.equals(director, that.director)) {
      return false;
    }
    return Objects.equals(score, that.score);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (director != null ? director.hashCode() : 0);
    result = 31 * result + (score != null ? score.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MovieEntity{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", director='"
        + director
        + '\''
        + ", score="
        + score
        + '}';
  }
}
