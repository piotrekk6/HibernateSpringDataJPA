package pl.krol.database.spring.ddl.PrimmaryKeys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class IdClass implements Serializable {
    Long id1;
    Long id2;
}
