package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters;

import com.ufmg.pds.bancofilmes.domains.GenreEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

@Converter
public class GenreEnumConverter implements AttributeConverter<List<GenreEnum>, String> {

  @Override
  public String convertToDatabaseColumn(List<GenreEnum> genres) {
    return ObjectUtils.isEmpty(genres) ? null : String.join(", ", genres.toString());
  }

  @Override
  public List<GenreEnum> convertToEntityAttribute(String savedGenres) {
    if (StringUtils.isEmpty(savedGenres)) {
      return null;
    } else {
      List<GenreEnum> genreEnumList = new ArrayList<>();
      List<String> genreStringList =
          Arrays.asList(savedGenres.replaceAll("[\\[\\](){}]", "").split(", "));
      genreStringList.forEach(
          genreString -> {
            GenreEnum genre = GenreEnum.valueOf(genreString);
            genreEnumList.add(genre);
          });
      return genreEnumList;
    }
  }
}
