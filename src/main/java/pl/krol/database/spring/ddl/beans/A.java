package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
