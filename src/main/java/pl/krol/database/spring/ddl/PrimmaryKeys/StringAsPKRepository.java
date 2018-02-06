package pl.krol.database.spring.ddl.PrimmaryKeys;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StringAsPKRepository extends JpaRepository<StringAsPK, Long> {

    List<StringAsPK> findById(Long id);

}
