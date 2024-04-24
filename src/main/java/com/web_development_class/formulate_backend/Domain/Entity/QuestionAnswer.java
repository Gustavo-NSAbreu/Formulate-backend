package com.web_development_class.formulate_backend.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web_development_class.formulate_backend.Domain.DTO.QuestionAnswerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "questionAnswer")
@Table(name = "questionAnswer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "question", nullable = false)
    private Question question;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "form_answer_id")
    private FormAnswer formAnswer;

    public QuestionAnswer(QuestionAnswerDTO newQuestionAnswer, Form form) {
        this.id = newQuestionAnswer.id();
        this.question = new Question(newQuestionAnswer.question(), form);
        this.description = newQuestionAnswer.description();
    }
}