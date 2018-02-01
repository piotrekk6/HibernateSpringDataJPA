package pl.krol.database.spring.ddl.service;

import pl.krol.database.spring.ddl.beans.Car;
import pl.krol.database.spring.ddl.enums.Color;

import java.util.List;

public interface CarRepository extends VehicleRepository<Car> {

    List<Car> findByName(String name);
    List<Car> findByMyColor(Color color);

}
