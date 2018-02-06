package pl.krol.database.spring.ddl.MappedSuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}
