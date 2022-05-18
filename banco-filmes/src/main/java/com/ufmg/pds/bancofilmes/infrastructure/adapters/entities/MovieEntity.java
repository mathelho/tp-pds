package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("title")
  @NotEmpty
  private String title;

  @JsonProperty("director")
  @NotEmpty(message = "The director should not be empty")
  private String director;

  @JsonProperty("score")
  @NotNull(message = "The Score should not be null")
  @Min(value = 1, message = "The score must not be lower than 1")
  @Max(value = 10, message = "The score must not be higher than 10")
  private Double score;

  @JsonProperty("synopsis")
  @NotEmpty
  private String synopsis;

  @JsonProperty("genre")
  @NotNull(message = "Movies need to have a genre")
  private GenreEnum genre;

  @JsonProperty("whereToWatch")
  @NotNull(message = "Needs  have at least one streaming option")
  private WhereToWatchEnum whereToWatch;

  @JsonProperty("imageUrl")
  @NotEmpty
  private String imageUrl;

  public MovieEntity() {}

  public MovieEntity(
      Long id,
      String title,
      String director,
      Double score,
      String synopsis,
      GenreEnum genre,
      WhereToWatchEnum whereToWatch,
      String imageUrl) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.score = score;
    this.synopsis = synopsis;
    this.genre = genre;
    this.whereToWatch = whereToWatch;
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public GenreEnum getGenre() {
    return genre;
  }

  public void setGenre(GenreEnum genre) {
    this.genre = genre;
  }

  public WhereToWatchEnum getWhereToWatch() {
    return whereToWatch;
  }

  public void setWhereToWatch(WhereToWatchEnum whereToWatch) {
    this.whereToWatch = whereToWatch;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
