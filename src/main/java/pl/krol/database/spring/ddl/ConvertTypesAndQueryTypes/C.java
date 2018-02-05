package pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.converters.DateToLongConverter;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.converters.DateToSqlDateConverter;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.enums.ColorEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class C {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long number;

    @NotBlank
    String name;

    @Convert(converter = DateToSqlDateConverter.class)
    @NotNull
    LocalDate myDate;

    @Convert(converter = DateToLongConverter.class)
    @NotNull
    LocalDate myDate2;

    @NotNull
    ColorEnum myColor;


    protected C() {
    }

    public C(Long number, String name, LocalDate myDate, LocalDate myDate2, ColorEnum myColor) {
        this.number = number;
        this.name = name;
        this.myDate = myDate;
        this.myDate2 = myDate2;
        this.myColor = myColor;
    }
}
