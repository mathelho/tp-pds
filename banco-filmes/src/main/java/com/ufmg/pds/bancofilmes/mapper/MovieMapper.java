package com.ufmg.pds.bancofilmes.mapper;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.requests.MoviePostRequestBody;
import com.ufmg.pds.bancofilmes.requests.MoviePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
  public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  public abstract Movie toMovie(MoviePostRequestBody moviePostRequestBody);

  public abstract Movie toMovie(MoviePutRequestBody moviePutRequestBody);
}
