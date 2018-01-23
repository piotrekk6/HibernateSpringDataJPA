package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.A;

import java.util.List;

public interface ARepository extends JpaRepository<A, Long> {

    List<A> findById(long id);

}
