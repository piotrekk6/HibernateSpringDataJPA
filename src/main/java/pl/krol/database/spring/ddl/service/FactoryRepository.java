package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Factory;

public interface FactoryRepository  extends JpaRepository<Factory, Long>{
}
