package com.example.blog.model;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Post {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer categoryId;
    private Integer viewCount;
    private Integer likeCount;
    private Date createdAt;
    private Date updatedAt;

    // 添加关联字段
    private List<Tag> tags;
    private User author;
    private Category category;
}