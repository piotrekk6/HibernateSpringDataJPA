package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Person;

public interface UserRepository extends JpaRepository<Person, Long> {

    Person getById(Long id);

}
