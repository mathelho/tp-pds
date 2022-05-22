package com.ufmg.pds.bancofilmes.domains.dtos;

import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;

public class MoviePutRequestBodyDTO {
  private Long id;
  private String title;
  private String director;
  private Double score;
  private String synopsis;
  private GenreEnum genre;
  private WhereToWatchEnum whereToWatch;
  private String imageUrl;
  private AdvisoryRatingEnum advisoryRating;

  public MoviePutRequestBodyDTO() {}

  public MoviePutRequestBodyDTO(
      Long id,
      String title,
      String director,
      Double score,
      String synopsis,
      GenreEnum genre,
      WhereToWatchEnum whereToWatch,
      String imageUrl,
      AdvisoryRatingEnum advisoryRating) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.score = score;
    this.synopsis = synopsis;
    this.genre = genre;
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

  public AdvisoryRatingEnum getAdvisoryRating() {
    return advisoryRating;
  }

  public void setAdvisoryRating(AdvisoryRatingEnum advisoryRating) {
    this.advisoryRating = advisoryRating;
  }
}
