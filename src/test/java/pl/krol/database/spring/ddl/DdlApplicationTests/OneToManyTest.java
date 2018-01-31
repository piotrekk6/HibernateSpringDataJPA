package pl.krol.database.spring.ddl.DdlApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krol.database.spring.ddl.beans.Comment;
import pl.krol.database.spring.ddl.beans.Post;
import pl.krol.database.spring.ddl.service.CommentRepository;
import pl.krol.database.spring.ddl.service.PostRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Test
public class OneToManyTest  extends AbstractTestNGSpringContextTests{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testAddRecord()
    {
        Post post= new Post();

        List<Comment> comments =new ArrayList<>();
        comments.add(new Comment());
        comments.add(new Comment());
        post.setComments(comments);
        postRepository.save(post);

        Assert.assertEquals(postRepository.findOne(post.getId()).getComments().size(),2);
        Assert.assertEquals(postRepository.findOne(post.getId()).getComments().get(0).getId(),comments.get(0).getId());
        Assert.assertEquals(postRepository.findOne(post.getId()).getComments().get(1).getId(),comments.get(1).getId());



    }

}
