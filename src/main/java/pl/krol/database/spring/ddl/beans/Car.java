package pl.krol.database.spring.ddl.beans;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import pl.krol.database.spring.ddl.enums.Color;

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
    Color myColor;


}
