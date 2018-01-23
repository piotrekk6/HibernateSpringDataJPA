package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.B;

import java.util.List;

public interface BRepository extends JpaRepository<B, Long> {

    List<B> findById(long id);

}