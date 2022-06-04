package com.ufmg.pds.bancofilmes.domains.dtos;

import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import java.util.List;

public class MoviePutRequestBodyDTO {
  private Long id;
  private String title;
  private String director;
  private Double imdbScore;
  private String synopsis;
  private List<GenreEnum> genres;
  private List<WhereToWatchEnum> whereToWatch;
  private String imageUrl;
  private AdvisoryRatingEnum advisoryRating;
  private String releaseYear;

  public MoviePutRequestBodyDTO() {}

  public MoviePutRequestBodyDTO(
      Long id,
      String title,
      String director,
      Double imdbScore,
      String synopsis,
      List<GenreEnum> genres,
      List<WhereToWatchEnum> whereToWatch,
      String imageUrl,
      AdvisoryRatingEnum advisoryRating,
      String releaseYear) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.imdbScore = imdbScore;
    this.synopsis = synopsis;
    this.genres = genres;
    this.whereToWatch = whereToWatch;
    this.imageUrl = imageUrl;
    this.advisoryRating = advisoryRating;
    this.releaseYear = releaseYear;
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
}
