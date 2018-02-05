package pl.krol.database.spring.ddl.Embeddedable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krol.database.spring.ddl.Embeddedable.Address;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    public Factory(Address address) {
        this.address = address;
    }
}
