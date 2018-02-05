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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Project> projects;

    public Employee(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(String name) {
        this.name = name;
    }

}
