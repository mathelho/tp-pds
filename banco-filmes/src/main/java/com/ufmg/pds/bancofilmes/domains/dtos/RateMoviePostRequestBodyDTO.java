package com.ufmg.pds.bancofilmes.domains.dtos;

public class RateMoviePostRequestBodyDTO {
  private Long id;
  private Double score;

  public RateMoviePostRequestBodyDTO() {}

  public RateMoviePostRequestBodyDTO(Long id, Double score) {
    this.id = id;
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }
}
