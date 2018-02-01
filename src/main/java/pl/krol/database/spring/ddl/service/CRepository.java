package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.krol.database.spring.ddl.beans.C;

import java.util.List;

public interface CRepository extends JpaRepository<C, Long> {

    List<C> findById(long id);

    @Query(value="select count(*) from c", nativeQuery = true)
    int countRecords();

    @Query(value="select * from c WHERE name LIKE 'ASDF'", nativeQuery = true)
    List<C> countRecordsWithNameASDF();

    List<C> findByName(String name);


}