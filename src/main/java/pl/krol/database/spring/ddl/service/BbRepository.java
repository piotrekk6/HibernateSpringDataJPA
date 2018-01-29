package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Bb;

public interface BbRepository extends JpaRepository<Bb, Long> {
}
