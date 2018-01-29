package pl.krol.database.spring.ddl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.Aa;
import pl.krol.database.spring.ddl.beans.Bb;
import pl.krol.database.spring.ddl.service.AaRepository;
import pl.krol.database.spring.ddl.service.BbRepository;

@Test
@SpringBootTest
public class TestsAaBbByTestNG extends AbstractTestNGSpringContextTests {

    int aaNumberofRecords;
    int bbNumberOfRecords;

    @Autowired
    private AaRepository aaRepository;

    @Autowired
    private BbRepository bbRepository;

    @BeforeMethod
    public void setVariables()
    {
        aaNumberofRecords=0;
        bbNumberOfRecords=0;
    }
    @Test
    public void testInsertOneRecordToAa()
    {
        aaNumberofRecords=aaRepository.findAll().size();
        bbNumberOfRecords= bbRepository.findAll().size();


        Bb bb=new Bb();
        Aa aa=new Aa(bb);

        bbRepository.save(bb);
        aaRepository.save(aa);

        Assert.assertEquals(bbRepository.findAll().size()-bbNumberOfRecords,1);
        Assert.assertEquals(aaRepository.findAll().size()-aaNumberofRecords,1);

    }



}
