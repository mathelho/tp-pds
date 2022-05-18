package com.ufmg.pds.bancofilmes.domains;

public enum GenreEnum {
  ACTION("Action"),
  ADVENTURE("Adventure"),
  COMEDY("Comedy"),
  DRAMA("Drama"),
  FANTASY("Fantasy"),
  HORROR("Horror"),
  HISTORICAL("Historical"),
  MYSTERY("Mystery"),
  ROMANCE("Romance"),
  SCIENCE_FICTION("Science Fiction"),
  THRILLER("Thriller");

  private final String value;

  GenreEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
