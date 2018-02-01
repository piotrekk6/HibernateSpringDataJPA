package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Vehicle;

import java.util.List;

public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, Long> {

    List<T> findById(Long id);
}
