package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Aa;

public interface AaRepository extends JpaRepository<Aa, Long> {
}
