package com.web_development_class.formulate_backend.Domain.DTO;

import com.web_development_class.formulate_backend.Domain.Entity.Form;

public record QuestionDTO(Long id, String description, Form form) {
    public QuestionDTO(Long id, String description, Form form) {
        this.id = id;
        this.description = description;
        this.form = form;
    }
    
    public QuestionDTO(String description, Form form) {
        this(null, description, form);
    }
}
