package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters.GenreEnumConverter;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters.WhereToWatchEnumConverter;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
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
  @NotEmpty(message = "The movie title should not be empty")
  private String title;

  @JsonProperty("director")
  @NotEmpty(message = "The movie director should not be empty")
  private String director;

  @JsonProperty("score")
  private Double score;

  @JsonProperty("imdbScore")
  @NotNull(message = "Movie IMDb score should not be null")
  @Min(value = 1, message = "Movie IMDb score must not be lower than 1")
  @Max(value = 10, message = "Movie IMDb score must not be higher than 10")
  private Double imdbScore;

  @JsonProperty("synopsis")
  @Column(name = "synopsis", columnDefinition = "LONGTEXT")
  @NotEmpty(message = "Movie synopsis should not be empty")
  private String synopsis;

  @JsonProperty("genres")
  @NotNull(message = "Movie genres should not be null")
  @Convert(converter = GenreEnumConverter.class)
  private List<GenreEnum> genres;

  @JsonProperty("whereToWatch")
  @NotNull(message = "Movie where to watch should not be null")
  @Convert(converter = WhereToWatchEnumConverter.class)
  private List<WhereToWatchEnum> whereToWatch;

  @JsonProperty("imageUrl")
  @NotEmpty(message = "Movie image url should not be empty")
  private String imageUrl;

  @JsonProperty("advisoryRating")
  @NotNull(message = "Movie advisory rating should not be null")
  private AdvisoryRatingEnum advisoryRating;

  @JsonProperty("releaseYear")
  @NotNull(message = "Movie release year should not be null")
  @Min(value = 1895, message = "Movie release year must not be lower than 1895")
  @Max(value = 2035, message = "Movie release year must not be greater than 2035")
  private String releaseYear;

  @JsonProperty("numberOfReviews")
  private Integer numberOfReviews = 0;

  public MovieEntity() {}

  public MovieEntity(
      Long id,
      String title,
      String director,
      Double score,
      Double imdbScore,
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
    this.imdbScore = imdbScore;
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

  public Double getImdbScore() {
    return imdbScore;
  }

  public void setImdbScore(Double imdbScore) {
    this.imdbScore = imdbScore;
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
