package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.C;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.enums.ColorEnum;
import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.CRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Test
public class ConvertTypesAndQueryVariantsTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CRepository cRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testWhetherDateIsTheSameAfterSaveAndRead() {
        C c = new C(4L, "Godxp", LocalDate.now(), LocalDate.now(), ColorEnum.RED);
        cRepository.save(c);

        Assert.assertEquals(cRepository.findById(c.getId()).get(0).getMyDate(), c.getMyDate());
        Assert.assertEquals(cRepository.findById(c.getId()).get(0).getMyDate2(), c.getMyDate2());
    }

    @Test
    public void testQueryVariants() {

        int cNumberOfRecordsBeforeQuery=cRepository.findAll().size();
        int cNumberOfRecordsAfterQuery;

        C c = new C(99L, "ASDF", LocalDate.of(1993, 2, 23), LocalDate.of(1990, 2, 23), ColorEnum.GREEN);
        C c1 = new C(99L, "ASDF", LocalDate.of(1995, 10, 1), LocalDate.of(1993, 4, 12), ColorEnum.RED);
        C c2 = new C(8L, "ASDF2", LocalDate.of(1845, 8, 4), LocalDate.of(2012, 12, 06), ColorEnum.BLUE);
        cRepository.save(c);
        cRepository.save(c1);
        cRepository.save(c2);

        //native query on repository
        cNumberOfRecordsAfterQuery=cRepository.findAll().size();
        Assert.assertEquals(cRepository.countRecords(),cNumberOfRecordsAfterQuery-cNumberOfRecordsBeforeQuery);

        //native query on entityManager
        BigInteger numberOfRecords =(BigInteger) entityManager.createNativeQuery("select count(*) from c").getSingleResult();
        Assert.assertEquals(numberOfRecords,BigInteger.valueOf(cRepository.findAll().size()));

        //native query on repository with name = ASDF
        Assert.assertEquals(cRepository.countRecordsWithNameASDF().size(),2);

        //native query on entityManager with name = ASDF
        List<C> cList= entityManager.createNativeQuery("select * from c WHERE name LIKE 'ASDF'").getResultList();
        Assert.assertEquals(cList.size(),2);

        //findByName from repository
        cList.clear();
        cList=cRepository.findByName("ASDF");
        Assert.assertEquals(cList.size(),2);

    }

}
