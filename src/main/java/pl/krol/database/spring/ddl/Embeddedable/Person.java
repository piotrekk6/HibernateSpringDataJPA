package pl.krol.database.spring.ddl.Embeddedable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserName name;

    @Embedded
    private Address address;


    public Person(UserName name, Address address) {
        this.name = name;
        this.address = address;
    }
}
