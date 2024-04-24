package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.List;
import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Domain.Entity.Question;

public record FormResponseDTO(Form form, List<Question> questions) {

    public FormResponseDTO(Form form, List<Question> questions) {
        this.form = form;
        this.questions = questions;
    }
}
