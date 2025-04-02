package com.example.blog.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface LikeMapper {
    @Insert("INSERT INTO post_like(user_id, post_id, created_at) VALUES(#{userId}, #{postId}, #{createdAt})")
    void insertLike(@Param("userId") Integer userId,
                    @Param("postId") Integer postId,
                    @Param("createdAt") Date createdAt);

    @Delete("DELETE FROM post_like WHERE user_id = #{userId} AND post_id = #{postId}")
    void deleteLike(@Param("userId") Integer userId,
                    @Param("postId") Integer postId);
}