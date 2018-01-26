package pl.krol.database.spring.ddl.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Bbb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
