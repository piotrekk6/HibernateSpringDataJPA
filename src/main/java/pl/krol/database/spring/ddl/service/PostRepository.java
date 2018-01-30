package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
