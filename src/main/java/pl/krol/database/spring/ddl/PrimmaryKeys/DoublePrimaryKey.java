package pl.krol.database.spring.ddl.PrimmaryKeys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(pl.krol.database.spring.ddl.PrimmaryKeys.IdClass.class)
public class DoublePrimaryKey {

    @Id
    private Long id1;


    @Id
    private Long id2;
}
