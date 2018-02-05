package pl.krol.database.spring.ddl.Embeddedable;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.Embeddedable.Factory;

import java.util.List;

public interface FactoryRepository  extends JpaRepository<Factory, Long>{

    List<Factory> findById(Long id);
}
