package pl.krol.database.spring.ddl.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    protected B() {
    }

    public B(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return String.format("A [id=%d, name=%s]", id, name);
    }
}
