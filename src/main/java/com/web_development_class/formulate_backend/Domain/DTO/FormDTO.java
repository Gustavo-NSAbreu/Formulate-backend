package com.web_development_class.formulate_backend.Domain.DTO;

import java.sql.Timestamp;

import com.web_development_class.formulate_backend.Domain.Entity.User;

public record FormDTO(Long id, String name, String description, Timestamp createdAt, User user) {
    public FormDTO(Long id, String name, String description, Timestamp createdAt, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.user = user;
    }
    public FormDTO(String name, String description, Timestamp createdAt, User user) {
        this(null, name, description, createdAt, user);
    }
    
}