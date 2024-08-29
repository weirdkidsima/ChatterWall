package com.weirdkidsima.ChatterWall.sevice;

import com.weirdkidsima.ChatterWall.model.User;
import com.weirdkidsima.ChatterWall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
