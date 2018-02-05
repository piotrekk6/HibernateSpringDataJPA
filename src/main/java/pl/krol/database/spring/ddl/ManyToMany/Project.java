package pl.krol.database.spring.ddl.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees ;

    public Project(String projectName, List<Employee> employees) {
        this.projectName = projectName;
        this.employees = employees;
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }
}
