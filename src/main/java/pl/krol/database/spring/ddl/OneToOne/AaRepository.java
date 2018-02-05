package pl.krol.database.spring.ddl.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AaRepository extends JpaRepository<Aa, Long> {

    List<Aa> findById(long id);

}
