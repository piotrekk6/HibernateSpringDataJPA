package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.Bike;
import pl.krol.database.spring.ddl.beans.C;
import pl.krol.database.spring.ddl.beans.Car;
import pl.krol.database.spring.ddl.enums.Color;
import pl.krol.database.spring.ddl.service.BikeRepository;
import pl.krol.database.spring.ddl.service.CarRepository;
import pl.krol.database.spring.ddl.service.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Test
public class VehicleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    public void testFindCarByColor()
    {


        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Carisma", Color.RED));
        carsList.add(new Car("Evo9", Color.BLUE));
        carRepository.save(carsList);


        List<Car> resultCarList = carRepository.findByMyColor(Color.RED);
        Assert.assertEquals(resultCarList.size(),1);
        for(Car car: resultCarList)
        {
            Assert.assertEquals(car.getMyColor(), Color.RED);
        }


    }

    @Test
    public void testFindBikeByNumber()
    {

        List<Bike> bikeList = new ArrayList<>();
        bikeList.add(new Bike(54321L));
        bikeList.add(new Bike(100L));
        bikeRepository.save(bikeList);

        Assert.assertEquals(bikeRepository.findByNumber(100L).size(),1);
        Assert.assertEquals(bikeRepository.findByNumber(100L).get(0).getId(), bikeList.get(1).getId());

    }

}
