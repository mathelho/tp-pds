package com.ufmg.pds.bancofilmes.infrastructure.mappers;

import com.ufmg.pds.bancofilmes.domains.Movie;
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MovieEntityMapper {
  public static final MovieEntityMapper INSTANCE = Mappers.getMapper(MovieEntityMapper.class);

  public abstract MovieEntity toMovieEntity(Movie movie);

  public abstract Movie toMovie(MovieEntity movieEntity);
}
