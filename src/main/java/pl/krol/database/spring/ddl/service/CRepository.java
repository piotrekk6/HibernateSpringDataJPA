package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.C;

import java.util.List;

public interface CRepository extends JpaRepository<C, Long> {

    List<C> findById(long id);

}