package pl.krol.database.spring.ddl.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.ManyToMany.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findById(Long id);
}
