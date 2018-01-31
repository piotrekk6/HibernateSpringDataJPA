package pl.krol.database.spring.ddl.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.repository.Temporal;
import pl.krol.database.spring.ddl.converters.DateToLongConverter;
import pl.krol.database.spring.ddl.converters.DateToSqlDateConverter;
import pl.krol.database.spring.ddl.enums.Color;

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
    Color myColor;


    protected C() {
    }

    public C(Long number, String name, LocalDate myDate, LocalDate myDate2, Color myColor) {
        this.number = number;
        this.name = name;
        this.myDate = myDate;
        this.myDate2 = myDate2;
        this.myColor = myColor;
    }
}
