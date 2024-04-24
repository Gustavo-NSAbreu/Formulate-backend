package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.List;
import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;
import com.web_development_class.formulate_backend.Domain.Entity.QuestionAnswer;

public record FormAnswerDTO(FormAnswer formAnswer, List<QuestionAnswer> questionAnswers) {

    public FormAnswerDTO(FormAnswer formAnswer, List<QuestionAnswer> questionAnswers) {
        this.formAnswer = formAnswer;
        this.questionAnswers = questionAnswers;
    }
}