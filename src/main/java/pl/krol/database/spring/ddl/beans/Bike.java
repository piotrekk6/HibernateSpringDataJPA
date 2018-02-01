package pl.krol.database.spring.ddl.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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
