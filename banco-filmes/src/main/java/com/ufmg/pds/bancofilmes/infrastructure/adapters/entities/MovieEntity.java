package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters.GenreEnumConverter;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters.WhereToWatchEnumConverter;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private Double score;

  @JsonProperty("synopsis")
  @NotEmpty
  private String synopsis;

  @JsonProperty("genres")
  @NotNull(message = "Movies need to have a genre")
  @Convert(converter = GenreEnumConverter.class)
  private List<GenreEnum> genres;

  @JsonProperty("whereToWatch")
  @NotNull(message = "Needs have at least one streaming option")
  @Convert(converter = WhereToWatchEnumConverter.class)
  private List<WhereToWatchEnum> whereToWatch;

  @JsonProperty("imageUrl")
  @NotEmpty
  private String imageUrl;

  @JsonProperty("advisoryRating")
  private AdvisoryRatingEnum advisoryRating;

  @JsonProperty("releaseYear")
  private String releaseYear;

  @JsonProperty("numberOfReviews")
  private Integer numberOfReviews = 0;

  public MovieEntity() {}

  public MovieEntity(
      Long id,
      String title,
      String director,
      Double score,
      String synopsis,
      List<GenreEnum> genres,
      List<WhereToWatchEnum> whereToWatch,
      String imageUrl,
      AdvisoryRatingEnum advisoryRating,
      String releaseYear,
      Integer numberOfReviews) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.score = score;
    this.synopsis = synopsis;
    this.genres = genres;
    this.whereToWatch = whereToWatch;
    this.imageUrl = imageUrl;
    this.advisoryRating = advisoryRating;
    this.releaseYear = releaseYear;
    this.numberOfReviews = numberOfReviews;
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

  public List<GenreEnum> getGenres() {
    return genres;
  }

  public void setGenres(List<GenreEnum> genres) {
    this.genres = genres;
  }

  public List<WhereToWatchEnum> getWhereToWatch() {
    return whereToWatch;
  }

  public void setWhereToWatch(List<WhereToWatchEnum> whereToWatch) {
    this.whereToWatch = whereToWatch;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public AdvisoryRatingEnum getAdvisoryRating() {
    return advisoryRating;
  }

  public void setAdvisoryRating(AdvisoryRatingEnum advisoryRating) {
    this.advisoryRating = advisoryRating;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
  }

  public Integer getNumberOfReviews() {
    return numberOfReviews;
  }

  public void setNumberOfReviews(Integer numberOfReviews) {
    this.numberOfReviews = numberOfReviews;
  }
}
