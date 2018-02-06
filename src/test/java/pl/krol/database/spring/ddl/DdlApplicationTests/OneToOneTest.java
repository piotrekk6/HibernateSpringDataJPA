package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.krol.database.spring.ddl.OneToOne.A;
import pl.krol.database.spring.ddl.OneToOne.B;
import pl.krol.database.spring.ddl.OneToOne.ARepository;
import pl.krol.database.spring.ddl.OneToOne.BRepository;

import java.util.List;

@Test
@SpringBootTest
public class OneToOneTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ARepository aRepository;

    @Autowired
    private BRepository bRepository;


    @Test
    public void testInsertOneRecord()
    {
        System.out.println("Wywołano metodę: testInsertOneRecord()" );
       A a1= new A();
       int countBeforeInsert=aRepository.findAll().size();
       aRepository.save(a1);
       int countAfterInert=aRepository.findAll().size();
       Assert.assertEquals((countAfterInert-countBeforeInsert),1);

    }

    @Test
    public void testFindByID()
    {
        System.out.println("Wywołano metodę: testFindByID()" );
        A a2 = new A();
        aRepository.save(a2);
        long expectedId=a2.getId();
        long id=aRepository.findById(expectedId).get(0).getId();
        Assert.assertEquals(id,expectedId);

    }

    @Test
    public void testInsertABWithRelation()
    {
        System.out.println("Wywołano metodę: testInsertABWithRelation()" );
        B b1=new B();
        B b2= new B();

        bRepository.save(b1);
        bRepository.save(b2);

        A a1 =new A(b1);
        A a2 = new A(b2);

        aRepository.save(a1);
        aRepository.save(a2);

        //System.out.println(aRepository.findAll());

        List<A> aResultList = aRepository.findById(a1.getId());
        Assert.assertEquals(aResultList.get(0).getBId(),b1.getId());

    }

    @Test
    public void deleteABWithRelation()
    {


    }

    @AfterClass
    @Ignore
    public void deleteAllFromDB()
    {

        System.out.println("Wywołano metodę @AfterClass: deleteAllFromDB()" );
        aRepository.deleteAll();
        bRepository.deleteAll();
        int aNumOfRecords=aRepository.findAll().size();
        int bNumOfRecords=bRepository.findAll().size();
        Assert.assertEquals(aNumOfRecords,0);
        Assert.assertEquals(bNumOfRecords,0);
        System.out.println("aNumOfRecords: " +aNumOfRecords + " bNumOfRecords: " +bNumOfRecords);

    }

    @BeforeMethod
    public void showHowManyRecordsInEntity()
    {
        int aNumOfRecords=aRepository.findAll().size();
        int bNumOfRecords=bRepository.findAll().size();
        System.out.println("aNumOfRecords: " +aNumOfRecords +" bNumOfRecords: " +bNumOfRecords);
    }



}
