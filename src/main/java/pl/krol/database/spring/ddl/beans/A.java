package pl.krol.database.spring.ddl.beans;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

@Entity
public class A {

    @GenericGenerator(
            name = "ASequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "A_SEQUENCE")}
    )
    @GeneratedValue(generator = "ASequenceGenerator")
    @Id
    private Long id;

    @OneToOne
    @JoinColumn
    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public Long getId() {
        return id;
    }
    public Long getBId()
    {
        return b.getId();
    }

    @Override
    public String toString() {
        return "A{" + "id=" + id + ", b=" + b + '}';
    }
}
