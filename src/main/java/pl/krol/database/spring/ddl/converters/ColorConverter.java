package pl.krol.database.spring.ddl.converters;

import pl.krol.database.spring.ddl.enums.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        switch (color)
        {
            case RED: return "R";
            case BLUE: return "B";
            case GREEN: return "G";
        }
        return null;
    }

    @Override
    public Color convertToEntityAttribute(String s) {
        switch (s)
        {
            case "R": return Color.RED;
            case "B": return Color.BLUE;
            case "G": return Color.GREEN;
        }
        return null;
    }
}
