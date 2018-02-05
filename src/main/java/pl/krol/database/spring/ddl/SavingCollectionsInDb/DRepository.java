package pl.krol.database.spring.ddl.SavingCollectionsInDb;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.SavingCollectionsInDb.D;

public interface DRepository extends JpaRepository<D,Long> {
    D getById(Long id);
}
