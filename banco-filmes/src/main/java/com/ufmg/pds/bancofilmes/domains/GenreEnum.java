package com.ufmg.pds.bancofilmes.domains;

public enum GenreEnum {
  ADVENTURE("Adventure");

  private final String value;

  GenreEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
