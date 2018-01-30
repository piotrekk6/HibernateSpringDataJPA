package pl.krol.database.spring.ddl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krol.database.spring.ddl.beans.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
