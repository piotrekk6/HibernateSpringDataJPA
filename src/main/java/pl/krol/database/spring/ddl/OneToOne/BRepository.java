package pl.krol.database.spring.ddl.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BRepository extends JpaRepository<B, Long> {


    List<B> findById(long id);

}