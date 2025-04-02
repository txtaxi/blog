package com.example.blog.mapper;

import com.example.blog.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("SELECT * FROM post")
    List<Post> findAll();

    @Select("SELECT * FROM post WHERE id = #{id}")
    Post findById(Integer id);

    @Insert("INSERT INTO post(title, content, user_id, category_id, created_at, updated_at) " +
            "VALUES(#{title}, #{content}, #{userId}, #{categoryId}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Post post);

    @Update("UPDATE post SET title=#{title}, content=#{content}, category_id=#{categoryId}, updated_at=#{updatedAt} " +
            "WHERE id=#{id}")
    void update(Post post);

    @Delete("DELETE FROM post WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT p.*, u.username as author_name, c.name as category_name " +
            "FROM post p LEFT JOIN user u ON p.user_id = u.id " +
            "LEFT JOIN category c ON p.category_id = c.id " +
            "WHERE p.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tags", column = "id",
                    many = @Many(select = "com.example.blog.mapper.TagMapper.findByPostId"))
    })
    Post findByIdWithDetails(Integer id);
}