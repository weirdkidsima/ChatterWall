package com.weirdkidsima.ChatterWall.repository;

import com.weirdkidsima.ChatterWall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
