package pl.krol.database.spring.ddl.beans;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class B {
    @GenericGenerator(
            name = "BSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "B_SEQUENCE")}
    )
    @GeneratedValue(generator = "BSequenceGenerator")
    @Id
    private Long id;


    public B() {
    }

    public Long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "B{" +
                "id=" + id +
                '}';
    }
}
