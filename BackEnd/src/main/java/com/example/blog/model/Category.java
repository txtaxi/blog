package com.example.blog.model;

import lombok.Data;
import java.util.Date;

@Data
public class Category {
    private Integer id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}