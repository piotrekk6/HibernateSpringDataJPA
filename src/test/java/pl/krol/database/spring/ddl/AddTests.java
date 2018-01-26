package pl.krol.database.spring.ddl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.A;
import pl.krol.database.spring.ddl.service.ARepository;

@Test
@SpringBootTest
public class AddTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private ARepository aRepository;

    @Test
    public void testInsertOneRecord()
    {
       A  a1= new A();
       int countBeforeInsert=aRepository.findAll().size();
       aRepository.save(a1);
       int countAfterInert=aRepository.findAll().size();
       Assert.assertEquals((countAfterInert-countBeforeInsert),1);
    }

    @Test
    public void testFindByID()
    {
        A a2 = new A();
        aRepository.save(a2);
        long expectedId=a2.getId();
        long id=aRepository.findById(expectedId).get(0).getId();
        Assert.assertEquals(id,expectedId);
    }


}
