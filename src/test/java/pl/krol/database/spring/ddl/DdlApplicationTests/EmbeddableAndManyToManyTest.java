package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.Embeddedable.*;
import pl.krol.database.spring.ddl.ManyToMany.Employee;
import pl.krol.database.spring.ddl.ManyToMany.Project;
import pl.krol.database.spring.ddl.ManyToMany.EmployeeRepository;
import pl.krol.database.spring.ddl.Embeddedable.FactoryRepository;
import pl.krol.database.spring.ddl.ManyToMany.ProjectRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Test
public class PersonEmbeddableTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @BeforeClass
    public void clean() {

        projectRepository.deleteAll();
        employeeRepository.deleteAll();
        factoryRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void testSavePerson() {
        Person user1 = new Person(new UserName("Piotr", "Kowalski"), new Address("Lublin", "Polska", "23-402", "Nadbystrzycka 55"));
        userRepository.save(user1);

        Factory factory1 = new Factory(new Address("Warszawa", "Polska", "33-333", "Wiejska"));
        factoryRepository.save(factory1);

        Assert.assertEquals(userRepository.findById(user1.getId()).get(0).getId(), user1.getId());
        Assert.assertEquals(factoryRepository.findById(factory1.getId()).get(0).getId(), factory1.getId());
    }

    @Test
    public void testManyToMany() {
        Employee employee1 = new Employee("Andrzej");
        Employee employee2 = new Employee("John");

        Project project1 = new Project("Db project");
        Project project2 = new Project("Spring project");
        Project project3 = new Project("C++ project");

        employee1.setProjects(Arrays.asList(project3));
        employee2.setProjects(Arrays.asList(project2, project1));
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee : employeeList) {
            Assert.assertNotNull(employee.getProjects());
        }

    }


}
