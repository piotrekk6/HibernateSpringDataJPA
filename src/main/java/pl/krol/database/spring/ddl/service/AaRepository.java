package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Aa;
import pl.krol.database.spring.ddl.beans.Bb;

import java.util.List;

public interface AaRepository extends JpaRepository<Aa, Long> {

    List<Aa> findById(long id);

}
