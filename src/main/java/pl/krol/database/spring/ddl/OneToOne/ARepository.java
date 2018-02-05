package pl.krol.database.spring.ddl.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ARepository extends JpaRepository<A, Long> {

    List<A> findById(long id);


}
