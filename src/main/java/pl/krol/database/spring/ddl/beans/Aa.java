package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Aa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn
    private Bb bb;
}
