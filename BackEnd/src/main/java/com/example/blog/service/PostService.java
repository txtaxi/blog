package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.mapper.PostMapper;
import com.example.blog.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostMapper postMapper;

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<Post> getAllPosts() {
        return postMapper.findAll();
    }

    public Post getPostById(Integer id) {
        return postMapper.findById(id);
    }

    public void createPost(Post post) {
        postMapper.insert(post);
    }

    public void updatePost(Post post) {
        postMapper.update(post);
    }

    public void deletePost(Integer id) {
        postMapper.delete(id);
    }

    public Post getPostWithDetails(Integer id) {
        Post post = postMapper.findByIdWithDetails(id);
        if(post == null) {
            throw new ResourceNotFoundException("文章未找到");
        }
        return post;
    }
}