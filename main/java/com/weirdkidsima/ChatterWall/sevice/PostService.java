package com.weirdkidsima.ChatterWall.sevice;

import com.weirdkidsima.ChatterWall.model.Post;
import com.weirdkidsima.ChatterWall.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post createPost(String nickname, String content){
        Post post = new Post();
        post.setNickname(nickname);
        post.setContent(content);
        post.setPostTime(LocalDateTime.now());
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, String content){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setContent(content);
        return postRepository.save(post);
    }

    public List<Post> getPostsByNickname(String nickname){
        return postRepository.findByNickname(nickname);
    }
}
