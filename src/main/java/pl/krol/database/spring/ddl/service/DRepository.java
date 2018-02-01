package pl.krol.database.spring.ddl.service;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.D;

public interface DRepository extends JpaRepository<D,Long> {
    D getById(Long id);
}
