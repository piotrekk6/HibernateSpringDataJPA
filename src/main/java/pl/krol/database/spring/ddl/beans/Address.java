package pl.krol.database.spring.ddl.beans;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {


    private String city;

    private String country;

    private String zip_code;

    private String street;

}
