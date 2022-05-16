package com.ufmg.pds.bancofilmes.domains;

public enum WhereToWatchEnum {
  NETFLIX("Netflix");

  private final String value;

  WhereToWatchEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
