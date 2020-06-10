package ro.bogdan.hibernatemappingdemo.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;

    @GetMapping("/create-dummy-post")
    @ResponseBody
    public Post createDummyPost() {
        Post post = new Post();
        post.setContent("Prima mea postarea bla bla bla...");

        Comment comment1 = new Comment();
        comment1.setContent("urata postare");

        Comment comment2 = new Comment();
        comment2.setContent("grozava postare");

        post.setComments(new ArrayList<>());
        post.getComments().add(comment1);
        post.getComments().add(comment2);

        postDao.save(post);

        return post;

    }
}
