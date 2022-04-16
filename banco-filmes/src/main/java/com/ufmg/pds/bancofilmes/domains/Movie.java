package com.ufmg.pds.bancofilmes.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("director")
  private String director;

  @JsonProperty("score")
  private Double score;

  public Movie() {}

  public Movie(Long id, String name, String director, Double score) {
    this.id = id;
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
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Movie movie = (Movie) o;

    if (!id.equals(movie.id)) return false;
    if (!name.equals(movie.name)) return false;
    if (!director.equals(movie.director)) return false;
    return score.equals(movie.score);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + director.hashCode();
    result = 31 * result + score.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Movie{"
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
