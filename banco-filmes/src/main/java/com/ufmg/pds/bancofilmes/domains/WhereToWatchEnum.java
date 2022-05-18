package com.ufmg.pds.bancofilmes.domains;

public enum WhereToWatchEnum {
  AMAZON_PRIME_VIDEO("Amazon Prime Video"),
  APPLE_TV_PLUS("Apple TV+"),
  CRUNCHYROLL("Crunchyroll"),
  DISNEY_PLUS("Disney+"),
  GLOBO_PLAY("Globo Play"),
  HBO_MAX("HBO Max"),
  HULU("Hulu"),
  NETFLIX("Netflix"),
  PARAMOUNT_PLUS("Paramount+"),
  STAR_PLUS("Star+");

  private final String value;

  WhereToWatchEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
