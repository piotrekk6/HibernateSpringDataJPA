package pl.krol.database.spring.ddl.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BbRepository extends JpaRepository<Bb, Long> {

    List<Bb> findById(long id);
}
