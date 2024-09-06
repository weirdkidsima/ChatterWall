package com.weirdkidsima.ChatterWall.controller;

import com.weirdkidsima.ChatterWall.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private PostService postService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/count/{nickname}")
    public long getPostCountByNickname(@PathVariable String nickname) {
        return postService.getPostsByNickname(nickname).size();
    }
}
