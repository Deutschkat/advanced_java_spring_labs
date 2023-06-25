package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.codingnomads.co.springsecurity.authentication.usernamepassword.models.UserPrincipal;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.Post;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.services.PostService;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/posts")
    public String getPosts(Model model){
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getPostsByCurrentUser();
        model.addAttribute("posts", posts);
        return "userPosts";
    }
}