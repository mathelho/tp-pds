package com.ufmg.pds.bancofilmes.domains.dtos;

import java.util.Objects;

public class MovieDTO {
  private Long id;
  private String name;
  private String director;
  private Double score;

  public MovieDTO() {}

  public MovieDTO(Long id, String name, String director, Double score) {
    this.id = id;
    this.name = name;
    this.director = director;
    this.score = score;
  }

  public MovieDTO(String name, String director, Double score) {
    this.name = name;
    this.director = director;
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
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

    MovieDTO movieDTO = (MovieDTO) o;

    if (!Objects.equals(id, movieDTO.id)) {
      return false;
    }
    if (!Objects.equals(name, movieDTO.name)) {
      return false;
    }
    if (!Objects.equals(director, movieDTO.director)) {
      return false;
    }
    return Objects.equals(score, movieDTO.score);
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
    return "MovieDTO{"
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
