package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 List<Employee> findById(Long id);
}
