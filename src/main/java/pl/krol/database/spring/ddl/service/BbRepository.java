package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Bb;

import java.util.List;

public interface BbRepository extends JpaRepository<Bb, Long> {

    List<Bb> findById(long id);
}
