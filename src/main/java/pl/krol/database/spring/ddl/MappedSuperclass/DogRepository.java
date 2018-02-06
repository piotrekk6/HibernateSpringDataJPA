package pl.krol.database.spring.ddl.MappedSuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
