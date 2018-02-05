package pl.krol.database.spring.ddl.SavingCollectionsInDb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    List<String> names;

    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    List<Integer> numbers;

    public D(List<String> names, List<Integer> numbers) {
        this.names = names;
        this.numbers = numbers;
    }
}
