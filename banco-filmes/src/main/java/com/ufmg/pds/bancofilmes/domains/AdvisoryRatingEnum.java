package com.ufmg.pds.bancofilmes.domains;

public enum AdvisoryRatingEnum {
  LIVRE("L"),
  DEZ("10"),
  DOZE("12"),
  QUATORZE("14"),
  DEZESSEIS("16"),
  DEZOITO("18");

  private final String value;

  AdvisoryRatingEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
