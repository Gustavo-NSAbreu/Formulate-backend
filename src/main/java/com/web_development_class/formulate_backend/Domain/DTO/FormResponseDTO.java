package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.Set;

import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Domain.Entity.Question;

public record FormResponseDTO(Form form, Set<Question> questions) {

    public FormResponseDTO(Form form, Set<Question> questions) {
        this.form = form;
        this.questions = questions;
    }
}
