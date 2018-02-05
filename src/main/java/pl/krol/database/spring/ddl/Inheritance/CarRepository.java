package pl.krol.database.spring.ddl.Inheritance;

import pl.krol.database.spring.ddl.ConvertTypesAndQueryTypes.enums.ColorEnum;

import java.util.List;

public interface CarRepository extends VehicleRepository<Car> {

    List<Car> findByName(String name);
    List<Car> findByMyColor(ColorEnum color);

}
