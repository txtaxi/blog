package com.example.blog.service;

import com.example.blog.mapper.LikeMapper;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service // 直接标记为Service组件
public class LikeService {
    private final LikeMapper likeMapper;

    // 构造器注入
    public LikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    /**
     * 点赞文章
     * @param postId 文章ID
     * @param userId 用户ID
     */
    public void likePost(Integer postId, Integer userId) {
        // 可以在这里添加业务逻辑，如验证用户是否存在
        likeMapper.insertLike(userId, postId, new Date());
    }

    /**
     * 取消点赞
     * @param postId 文章ID
     * @param userId 用户ID
     */
    public void unlikePost(Integer postId, Integer userId) {
        likeMapper.deleteLike(userId, postId);
    }
}