package com.ufmg.pds.bancofilmes.mapper;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO;
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
  public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  public abstract Movie toMovie(MoviePostRequestBodyDTO moviePostRequestBodyDTO);

  public abstract Movie toMovie(MoviePutRequestBodyDTO moviePutRequestBodyDTO);

  public abstract Movie toMovie(MovieEntity movieEntity);

  public abstract MovieEntity toMovieEntity(Movie movie);
}
