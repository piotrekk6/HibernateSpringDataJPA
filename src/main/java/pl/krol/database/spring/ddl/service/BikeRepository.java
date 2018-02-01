package pl.krol.database.spring.ddl.service;

import pl.krol.database.spring.ddl.beans.Bike;

import java.util.List;

public interface BikeRepository extends VehicleRepository<Bike> {

    List<Bike> findByNumber(Long number);

}
