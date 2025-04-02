package com.example.blog.model;

import lombok.Data;
import java.util.Date;

@Data
public class Comment {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer postId;
    private Date createdAt;

    // 关联字段
    private User user;
}