package pl.krol.database.spring.ddl.beans;

import javax.persistence.*;

@Entity
public class Bbb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
