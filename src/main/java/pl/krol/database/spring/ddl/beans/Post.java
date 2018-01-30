package pl.krol.database.spring.ddl.beans;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="post_id")
    private List<Comment> comment;


}
