package com.web_development_class.formulate_backend.Domain.DTO;


public record QuestionDTO(Long id, String description) {
    public QuestionDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    
    public QuestionDTO(String description) {
        this(null, description);
    }
}
