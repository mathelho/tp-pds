package com.ufmg.pds.bancofilmes.domains.mappers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
  public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  public abstract Movie moviePostRequestBodyDTOToMovie(
      MoviePostRequestBodyDTO moviePostRequestBodyDTO);

  public abstract Movie moviePutRequestBodyDTOToMovie(
      MoviePutRequestBodyDTO moviePutRequestBodyDTO);
}
