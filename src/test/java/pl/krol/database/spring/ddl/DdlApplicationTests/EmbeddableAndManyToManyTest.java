package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.Embeddedable.*;
import pl.krol.database.spring.ddl.ManyToMany.*;
import pl.krol.database.spring.ddl.Embeddedable.FactoryRepository;
import pl.krol.database.spring.ddl.MappedSuperclass.Dog;
import pl.krol.database.spring.ddl.MappedSuperclass.DogRepository;
import pl.krol.database.spring.ddl.PrimmaryKeys.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Test
public class EmbeddableAndManyToManyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private StringAsPKRepository stringAsPKRepository;

    @Autowired
    private DoublePrimmaryKeyRepository doublePrimmaryKeyRepository;

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

    @Test
    public void testMappedSuperclass() {
        Dog dog1 = new Dog();
        dogRepository.save(dog1);
        Assert.assertEquals(dogRepository.findOne(dog1.getId()).getId(), dog1.getId());


    }

    @Test
    public void testStingAsPK() {
        List<StringAsPK> sapk = new ArrayList<>(Arrays.asList(new StringAsPK(), new StringAsPK(), new StringAsPK(), new StringAsPK()));
        stringAsPKRepository.save(sapk);
        System.out.println(sapk);
        List<StringAsPK> resultList = stringAsPKRepository.findAll();
        for (StringAsPK record : resultList) {
            Assert.assertNotNull(sapk.contains(record));
        }
    }

    @Test
    public void testAddCompositeKeyRecords() {
        DoublePrimaryKey dpk = new DoublePrimaryKey(1L, 4L);
        doublePrimmaryKeyRepository.save(dpk);

        DoublePrimaryKey fetchedRecord = doublePrimmaryKeyRepository.findOne(new IdClass(1L, 4L));
        Assert.assertEquals(dpk.getId1(), fetchedRecord.getId1());
        Assert.assertEquals(dpk.getId2(), fetchedRecord.getId2());
    }
}
