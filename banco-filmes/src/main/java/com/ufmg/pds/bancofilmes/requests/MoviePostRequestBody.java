package com.ufmg.pds.bancofilmes.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MoviePostRequestBody {
  @JsonProperty("name")
  private String name;

  @JsonProperty("director")
  private String director;

  @JsonProperty("score")
  private Double score;

  public MoviePostRequestBody() {}

  public MoviePostRequestBody(String name, String director, Double score) {
    this.name = name;
    this.director = director;
    this.score = score;
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

    MoviePostRequestBody that = (MoviePostRequestBody) o;

    if (!Objects.equals(name, that.name)) return false;
    if (!Objects.equals(director, that.director)) return false;
    return Objects.equals(score, that.score);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (director != null ? director.hashCode() : 0);
    result = 31 * result + (score != null ? score.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MoviePostRequestBody{"
        + "name='"
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
