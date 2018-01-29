package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Bb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Aa aa;

    public Bb() {
    }

    public Bb(Aa aa)
    {
        this.aa=aa;
    }

}

