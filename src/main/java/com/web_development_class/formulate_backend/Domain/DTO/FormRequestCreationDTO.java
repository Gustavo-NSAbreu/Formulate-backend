package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.Set;

import com.web_development_class.formulate_backend.Domain.Entity.Form;

public record FormRequestCreationDTO(Form form, Set<QuestionDTO> questions) {

    public FormRequestCreationDTO(Form form, Set<QuestionDTO> questions) {
        this.form = form;
        this.questions = questions;
    }
}
