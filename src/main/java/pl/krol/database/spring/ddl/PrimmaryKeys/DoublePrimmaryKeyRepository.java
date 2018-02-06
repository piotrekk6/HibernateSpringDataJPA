package pl.krol.database.spring.ddl.PrimmaryKeys;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoublePrimmaryKeyRepository  extends JpaRepository<DoublePrimaryKey, IdClass>{
}
