package com.example.blog.controller;

import com.example.blog.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/post/{postId}/user/{userId}")
    public void likePost(@PathVariable Integer postId, @PathVariable Integer userId) {
        likeService.likePost(postId, userId);
    }

    @DeleteMapping("/post/{postId}/user/{userId}")
    public void unlikePost(@PathVariable Integer postId, @PathVariable Integer userId) {
        likeService.unlikePost(postId, userId);
    }
}