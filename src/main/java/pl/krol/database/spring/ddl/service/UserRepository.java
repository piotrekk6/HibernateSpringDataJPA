package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Person;

import java.util.List;

public interface UserRepository extends JpaRepository<Person, Long> {

    List<Person> findById(Long id);

}
