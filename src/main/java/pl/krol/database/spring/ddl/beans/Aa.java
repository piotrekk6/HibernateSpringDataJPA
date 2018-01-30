package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Aa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Bb bb;

    public Aa() {
    }

    public Aa(Bb bb) {
        this.bb = bb;
    }

    public Long getId() {
        return id;
    }

    public Long getBbId() {
        return bb.getId();
    }

    @Override
    public String toString() {
        return "Aa{" +
                "id=" + id +
                ", bb=" + bb.getId() +
                '}';
    }
}
