package com.weirdkidsima.ChatterWall.controller;

import com.weirdkidsima.ChatterWall.model.Post;
import com.weirdkidsima.ChatterWall.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestParam String nickname, @RequestParam String content){
        return postService.createPost(nickname, content);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestParam String content){
        return postService.updatePost(id, content);
    }
}
