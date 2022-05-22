package com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.converters;

import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

@Converter
public class WhereToWatchEnumConverter
    implements AttributeConverter<List<WhereToWatchEnum>, String> {

  @Override
  public String convertToDatabaseColumn(List<WhereToWatchEnum> whereToWatchEnumList) {
    return ObjectUtils.isEmpty(whereToWatchEnumList)
        ? null
        : String.join(", ", whereToWatchEnumList.toString());
  }

  @Override
  public List<WhereToWatchEnum> convertToEntityAttribute(String savedWhereToWatch) {
    if (StringUtils.isEmpty(savedWhereToWatch)) {
      return null;
    } else {
      List<WhereToWatchEnum> whereToWatchEnumList = new ArrayList<>();
      List<String> whereToWatchStringList =
          Arrays.asList(savedWhereToWatch.replaceAll("[\\[\\](){}]", "").split(", "));
      whereToWatchStringList.forEach(
          whereToWatchString -> {
            WhereToWatchEnum whereToWatch = WhereToWatchEnum.valueOf(whereToWatchString);
            whereToWatchEnumList.add(whereToWatch);
          });
      return whereToWatchEnumList;
    }
  }
}
