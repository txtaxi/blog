package com.example.blog.service;

import com.example.blog.mapper.TagMapper;
import com.example.blog.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagMapper tagMapper;

    public TagService(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    public List<Tag> findByPostId(Integer postId) {
        return tagMapper.findByPostId(postId);
    }
}