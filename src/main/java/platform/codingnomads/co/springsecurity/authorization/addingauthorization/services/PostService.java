package platform.codingnomads.co.springsecurity.authorization.addingauthorization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.Post;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @PreFilter(value = "filterObject.author != authentication.principal.username", filterTarget = "posts")
    public void createPosts(List<Post> posts) {
        postRepository.saveAll(posts);
    }

    @PostFilter("filterObject.author == authentication.principal.username")
    public List<Post> getPostsByCurrentUser() {
        return postRepository.findAll();
    }
}