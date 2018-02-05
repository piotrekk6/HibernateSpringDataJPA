package pl.krol.database.spring.ddl.OneToOne;

import javax.persistence.*;

@Entity
public class Bb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Aa aa;

    public Bb() {
    }

    public Bb(Aa aa)
    {
        this.aa=aa;
    }


    public Long getId() {
        return id;
    }

    public Long getAaId() {
        return aa.getId();
    }

    public void setAa(Aa aa)
    {
        this.aa=aa;
    }

    @Override
    public String toString() {
        return "Bb{" +
                "id=" + id +
                ", aa=" + aa.getId() +
                '}';
    }
}

