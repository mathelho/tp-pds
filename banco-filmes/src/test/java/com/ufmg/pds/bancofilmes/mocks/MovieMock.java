package com.ufmg.pds.bancofilmes.mocks;

import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum;
import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MovieMock {
  public static Movie createMovie() {
    return new Movie(
        1L,
        "Demon Slayer - Mugen Train: O Filme",
        "Haruo Sotozaki",
        0.0,
        8.2,
        "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
            + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
            + "demônio que tem atormentado as pessoas.",
        List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
        List.of(WhereToWatchEnum.CRUNCHYROLL),
        "https://i.imgur.com/SrWGiOE.jpg",
        AdvisoryRatingEnum.QUATORZE,
        "2020",
        0);
  }

  public static Movie createMovie(Long id, String title, Double score) {
    return new Movie(
            id,
            title,
            "Haruo Sotozaki",
            score,
            8.2,
            "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
                    + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
                    + "demônio que tem atormentado as pessoas.",
            List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
            List.of(WhereToWatchEnum.CRUNCHYROLL),
            "https://i.imgur.com/SrWGiOE.jpg",
            AdvisoryRatingEnum.QUATORZE,
            "2020",
            0);
  }

  public static MoviePostRequestBodyDTO createMoviePostRequestBody() {
    return new MoviePostRequestBodyDTO(
        "Demon Slayer - Mugen Train: O Filme",
        "Haruo Sotozaki",
        8.2,
        "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
            + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
            + "demônio que tem atormentado as pessoas.",
        List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
        List.of(WhereToWatchEnum.CRUNCHYROLL),
        "https://i.imgur.com/SrWGiOE.jpg",
        AdvisoryRatingEnum.QUATORZE,
        "2020");
  }

  public static MoviePostRequestBodyDTO createMoviePostRequestBody(String title, Double imdbScore, String releaseYear) {
    return new MoviePostRequestBodyDTO(
            title,
            "Haruo Sotozaki",
            imdbScore,
            "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
                    + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
                    + "demônio que tem atormentado as pessoas.",
            List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
            List.of(WhereToWatchEnum.CRUNCHYROLL),
            "https://i.imgur.com/SrWGiOE.jpg",
            AdvisoryRatingEnum.QUATORZE,
            releaseYear);
  }

  public static RateMoviePostRequestBodyDTO createRateMoviePostRequestBody(Double score) {
    return new RateMoviePostRequestBodyDTO(1L, score);
  }

  public static MoviePutRequestBodyDTO createMoviePutRequestBody() {
    return new MoviePutRequestBodyDTO(
        1L,
        "Demon Slayer - Mugen Train: O Filme",
        "Haruo Sotozaki",
        8.2,
        "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
            + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
            + "demônio que tem atormentado as pessoas.",
        List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
        List.of(WhereToWatchEnum.CRUNCHYROLL),
        "https://i.imgur.com/SrWGiOE.jpg",
        AdvisoryRatingEnum.QUATORZE,
        "2020");
  }

  public static MovieEntity createMovieEntity() {
    return new MovieEntity(
        1L,
        "Demon Slayer - Mugen Train: O Filme",
        "Haruo Sotozaki",
        0.0,
        8.2,
        "Tanjiro Kamado, junto com Inosuke Hashibira e Zenitsu Agatsuma embarcam no Trem do "
            + "Infinito em uma nova missão com o Pilar de Fogo, Kyojuro Rengoku, para derrotar um "
            + "demônio que tem atormentado as pessoas.",
        List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
        List.of(WhereToWatchEnum.CRUNCHYROLL),
        "https://i.imgur.com/SrWGiOE.jpg",
        AdvisoryRatingEnum.QUATORZE,
        "2020",
        0);
  }
}
