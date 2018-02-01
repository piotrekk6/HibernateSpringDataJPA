package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.D;
import pl.krol.database.spring.ddl.service.DRepository;

import java.util.*;

@SpringBootTest
@Test
public class DTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private DRepository dRepository;


    @Test
    public void testQuery() {
        String[] s1 = {"a", "b", "z", "a", "d"};
        Integer[] i1 = {3, 2, 7, 11, 10, 191, 5};


        List<String> stringSet = new ArrayList<>(Arrays.asList(s1));
        List<Integer> integerSet = new ArrayList<>(Arrays.asList(i1));
        System.out.println(stringSet.toString());
        System.out.println(integerSet.toString());

        D d1= new D(stringSet,integerSet);
        dRepository.save(d1);
        dRepository.getById(d1.getId()).getNames();
        Assert.assertEquals(dRepository.getById(d1.getId()).getNames(),stringSet);
        Assert.assertEquals(dRepository.getById(d1.getId()).getNumbers(), integerSet);



    }


}
