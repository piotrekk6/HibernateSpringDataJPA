package pl.krol.database.spring.ddl.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.ManyToMany.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 List<Employee> findById(Long id);
}
