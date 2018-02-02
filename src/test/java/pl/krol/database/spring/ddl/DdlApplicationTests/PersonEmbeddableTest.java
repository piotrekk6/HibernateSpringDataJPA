package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.Factory;
import pl.krol.database.spring.ddl.beans.Person;
import pl.krol.database.spring.ddl.beans.Address;
import pl.krol.database.spring.ddl.beans.UserName;
import pl.krol.database.spring.ddl.service.FactoryRepository;
import pl.krol.database.spring.ddl.service.UserRepository;

@SpringBootTest
@Test
public class PersonEmbeddableTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Test
    public void testSavePerson()
    {
        Person user1= new Person(new UserName("Piotr","Kowalski"),new Address("Lublin","Polska", "23-402","Nadbystrzycka 55"));
        userRepository.save(user1);
        System.out.println(user1.toString());

        Factory factory1= new Factory(new Address("Warszawa","Polska","33-333","Wiejska"));
        factoryRepository.save(factory1);
    }

    @Test
    public void testManyToMany()
    {

    }

}
