package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Aaa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToMany
//    @JoinTable
//    private Bbb bbb;


}
