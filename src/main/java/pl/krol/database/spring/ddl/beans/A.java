package pl.krol.database.spring.ddl.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected A() {
    }

}
