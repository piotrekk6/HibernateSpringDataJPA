package pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;

@Converter
public class DateToLongConverter implements AttributeConverter<LocalDate, Long> {
    @Override
    public Long convertToDatabaseColumn(LocalDate localDate) {
        return localDate.toEpochDay();
    }

    @Override
    public LocalDate convertToEntityAttribute(Long aLong) {
        return LocalDate.ofEpochDay(aLong);
    }
}
