package pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.converters;

import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.enums.ColorEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<ColorEnum, String> {

    @Override
    public String convertToDatabaseColumn(ColorEnum color) {
        switch (color)
        {
            case RED: return "R";
            case BLUE: return "B";
            case GREEN: return "G";
        }
        return null;
    }

    @Override
    public ColorEnum convertToEntityAttribute(String s) {
        switch (s)
        {
            case "R": return ColorEnum.RED;
            case "B": return ColorEnum.BLUE;
            case "G": return ColorEnum.GREEN;
        }
        return null;
    }
}
