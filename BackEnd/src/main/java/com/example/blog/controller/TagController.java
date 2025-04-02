package com.example.blog.controller;

import com.example.blog.model.Tag;
import com.example.blog.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.findAll();
    }

    @GetMapping("/post/{postId}")
    public List<Tag> getTagsByPostId(@PathVariable Integer postId) {
        return tagService.findByPostId(postId);
    }
}