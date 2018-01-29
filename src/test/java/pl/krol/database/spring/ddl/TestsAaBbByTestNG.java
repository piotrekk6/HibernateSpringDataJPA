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

import java.util.ArrayList;
import java.util.List;

@Test
@SpringBootTest
public class TestsAaBbByTestNG extends AbstractTestNGSpringContextTests {

    int aaNumberOfRecords;
    int bbNumberOfRecords;

    @Autowired
    private AaRepository aaRepository;

    @Autowired
    private BbRepository bbRepository;

    @BeforeMethod
    public void setVariables()
    {
        aaNumberOfRecords=0;
        bbNumberOfRecords=0;
    }
    @Test
    public void testInsertOneRecordToAaAndBbWithoutRelationship()
    {
        aaNumberOfRecords=aaRepository.findAll().size();
        bbNumberOfRecords= bbRepository.findAll().size();


        Bb bb=new Bb();
        Aa aa=new Aa();

        bbRepository.save(bb);
        aaRepository.save(aa);


        Assert.assertEquals(aaRepository.findAll().size()-aaNumberOfRecords,1);
        Assert.assertEquals(bbRepository.findAll().size()-bbNumberOfRecords,1);
    }

    @Test
    public void testInsertOneRecordToAaAndBbWithRelationship()
    {
        List<Aa> aaList= new ArrayList<>();
        List<Bb> bbList= new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            bbList.add(new Bb());
            System.out.println("B id: "+ bbList.get(i));
            aaList.add(new Aa(bbList.get(i)));      // przypisz id Bb do id Aa
            System.out.println("A id: "+ aaList.get(i));
            bbList.get(i).setAa(aaList.get(i));  // przypisz id Aa do id Bb
        }
        //bbRepository.save(bbList);
        aaRepository.save(aaList);


    }



}
