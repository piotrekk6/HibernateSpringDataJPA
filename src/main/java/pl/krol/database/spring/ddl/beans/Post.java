package pl.krol.database.spring.ddl.beans;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="post_id", nullable = false)
    private List<Comment> comments;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Long getId() {
        return id;
    }
}
