package pl.krol.database.spring.ddl.Embeddedable;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserName {

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

}
