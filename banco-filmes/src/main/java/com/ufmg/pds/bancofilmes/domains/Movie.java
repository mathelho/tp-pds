package com.ufmg.pds.bancofilmes.domains;

import java.util.List;

public class Movie {
  private Long id;
  private String title;
  private String director;
  private Double score;
  private String synopsis;
  private List<GenreEnum> genres;
  private List<WhereToWatchEnum> whereToWatch;
  private String imageUrl;
  private AdvisoryRatingEnum advisoryRating;

  public Movie() {}

  public Movie(
      Long id,
      String title,
      String director,
      Double score,
      String synopsis,
      List<GenreEnum> genres,
      List<WhereToWatchEnum> whereToWatch,
      String imageUrl,
      AdvisoryRatingEnum advisoryRating) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.score = score;
    this.synopsis = synopsis;
    this.genres = genres;
    this.whereToWatch = whereToWatch;
    this.imageUrl = imageUrl;
    this.advisoryRating = advisoryRating;
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
}
