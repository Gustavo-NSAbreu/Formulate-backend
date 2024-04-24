package com.web_development_class.formulate_backend.Domain.DTO;

public record QuestionAnswerDTO(Long id, String description, QuestionDTO question) {
    public QuestionAnswerDTO(Long id, String description, QuestionDTO question) {
        this.id = id;
        this.description = description;
        this.question = question;
    }
    
    public QuestionAnswerDTO(String description, QuestionDTO question) {
        this(null, description, question);
    }
}
