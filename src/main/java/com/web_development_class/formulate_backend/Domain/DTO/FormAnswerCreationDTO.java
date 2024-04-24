package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.List;
import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;

public record FormAnswerCreationDTO(FormAnswer formAnswer, List<QuestionAnswerDTO> questionAnswers) {

    public FormAnswerCreationDTO(FormAnswer formAnswer, List<QuestionAnswerDTO> questionAnswers) {
        this.formAnswer = formAnswer;
        this.questionAnswers = questionAnswers;
    }
}