package com.weirdkidsima.ChatterWall.repository;

import com.weirdkidsima.ChatterWall.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByNickname(String nickname);
}
