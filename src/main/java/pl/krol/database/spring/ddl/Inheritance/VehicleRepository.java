package pl.krol.database.spring.ddl.Inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, Long> {

    List<T> findById(Long id);
}
