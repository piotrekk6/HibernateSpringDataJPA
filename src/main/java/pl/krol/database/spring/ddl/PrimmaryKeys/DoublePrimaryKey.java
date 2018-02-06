package pl.krol.database.spring.ddl.PrimmaryKeys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(pl.krol.database.spring.ddl.PrimmaryKeys.IdClass.class)
public class DoublePrimmaryKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id2;
}
