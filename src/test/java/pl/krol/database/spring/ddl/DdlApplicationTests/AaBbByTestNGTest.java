package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.OneToOne.Aa;
import pl.krol.database.spring.ddl.OneToOne.Bb;
import pl.krol.database.spring.ddl.OneToOne.AaRepository;
import pl.krol.database.spring.ddl.OneToOne.BbRepository;

import java.util.ArrayList;
import java.util.List;

@Test
@SpringBootTest
public class AaBbByTestNGTest extends AbstractTestNGSpringContextTests {

    int aaNumberOfRecordsBeforeQuery;
    int bbNumberOfRecordsBeforeQuery;
    int aaNumberOfRecordsAfterQuery;
    int bbNumberOfRecordsAfterQuery;

    @Autowired
    private AaRepository aaRepository;

    @Autowired
    private BbRepository bbRepository;

    @BeforeMethod
    public void setVariables()
    {
        aaNumberOfRecordsBeforeQuery =aaRepository.findAll().size();
        bbNumberOfRecordsBeforeQuery =aaRepository.findAll().size();
        aaNumberOfRecordsAfterQuery =0;
        bbNumberOfRecordsAfterQuery =0;
    }
    @Test
    public void testInsertOneRecordToAaAndBbWithoutRelationship()
    {

        Bb bb=new Bb();
        Aa aa=new Aa();

        bbRepository.save(bb);
        aaRepository.save(aa);

        aaNumberOfRecordsAfterQuery =aaRepository.findAll().size();
        bbNumberOfRecordsAfterQuery =aaRepository.findAll().size();

        Assert.assertEquals(aaNumberOfRecordsAfterQuery - aaNumberOfRecordsBeforeQuery,1);
        Assert.assertEquals(bbNumberOfRecordsAfterQuery - bbNumberOfRecordsBeforeQuery,1);
    }

    @Test
    public void testInsertRecordsToAaAndBbWithRelationship()
    {
        List<Aa> aaList= new ArrayList<>();
        List<Bb> bbList= new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            bbList.add(new Bb());
            System.out.println("B id: "+ bbList.get(i).getId());
            aaList.add(new Aa(bbList.get(i)));      // przypisz id Bb do  Aa
            System.out.println("A id: "+ aaList.get(i).getId());
            bbList.get(i).setAa(aaList.get(i));  // przypisz id Aa do  Bb
            aaRepository.save(aaList.get(i));
        }

        aaNumberOfRecordsAfterQuery =aaRepository.findAll().size();
        bbNumberOfRecordsAfterQuery =aaRepository.findAll().size();

        Assert.assertEquals(aaNumberOfRecordsAfterQuery - aaNumberOfRecordsBeforeQuery,10);
        Assert.assertEquals(bbNumberOfRecordsAfterQuery - bbNumberOfRecordsBeforeQuery,10);

        for(int i=0;i<10;i++)
        {
            Assert.assertEquals(bbList.get(i).getId(), aaList.get(i).getBbId());
            //System.out.print(bbList.get(i).getId()+aaList.get(i).getBbId());
            Assert.assertEquals(bbList.get(i).getAaId(), aaList.get(i).getId());
            //System.out.println(bbList.get(i).getAaId()+aaList.get(i).getId());
        }

    }

    @Test
    public void testDeleteCascade()
    {
        Bb bb=new Bb();
        Aa aa=new Aa(bb);
        bb.setAa(aa);

        aaRepository.save(aa);
        aaRepository.delete(aa);

        System.out.println(aa.toString());

        aaNumberOfRecordsAfterQuery =aaRepository.findAll().size();
        bbNumberOfRecordsAfterQuery =aaRepository.findAll().size();

        Assert.assertEquals(aaNumberOfRecordsAfterQuery - aaNumberOfRecordsBeforeQuery,0);
        Assert.assertEquals(bbNumberOfRecordsAfterQuery - bbNumberOfRecordsBeforeQuery,0);
        Assert.assertEquals(aaRepository.findById(aa.getId()).size(),0);


    }




}
