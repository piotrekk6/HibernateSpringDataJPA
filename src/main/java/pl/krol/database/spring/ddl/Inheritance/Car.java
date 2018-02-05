package pl.krol.database.spring.ddl.Inheritance;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.enums.ColorEnum;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car extends  Vehicle{

    @NotBlank
    String name;

    @NotNull
    ColorEnum myColor;


}
