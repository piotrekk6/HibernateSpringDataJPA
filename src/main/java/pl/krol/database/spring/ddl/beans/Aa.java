package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Aa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Bb bb;

    public Aa() {
    }

    public Aa(Bb bb) {
        this.bb = bb;
        this.bb = bb;
    }
}
