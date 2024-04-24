package com.web_development_class.formulate_backend.Domain.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web_development_class.formulate_backend.Domain.DTO.QuestionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "question")
@Table(name = "question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "form", nullable = false)
    @JsonIgnore
    private Form form;

    @OneToMany(mappedBy = "question")
    private Set<QuestionAnswer> questionAnswers;

    public Question(QuestionDTO question, Form form) {
        this.id = question.id();
        this.description = question.description();
        this.form = question.form();
        this.form = form;
    }

    public void update(Question question) {
        this.description = question.getDescription();
    }
}
