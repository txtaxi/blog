package com.example.blog.mapper;

import com.example.blog.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {
    // 查询所有标签
    @Select("SELECT * FROM tag")
    List<Tag> findAll();

    // 根据文章ID查询标签
    @Select("SELECT t.* FROM tag t JOIN post_tag pt ON t.id = pt.tag_id WHERE pt.post_id = #{postId}")
    List<Tag> findByPostId(Integer postId);
}