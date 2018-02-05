package pl.krol.database.spring.ddl.Inheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
public class Bike extends Vehicle {

    @Column(unique=true)
    private Long number;

    public Bike() {
    }

    public Bike(Long number) {
        this.number = number;
    }
}
