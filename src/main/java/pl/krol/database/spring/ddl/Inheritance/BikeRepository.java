package pl.krol.database.spring.ddl.Inheritance;

import java.util.List;

public interface BikeRepository extends VehicleRepository<Bike> {

    List<Bike> findByNumber(Long number);

}
