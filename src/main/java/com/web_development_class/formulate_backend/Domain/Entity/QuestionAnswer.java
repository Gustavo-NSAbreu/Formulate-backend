package com.web_development_class.formulate_backend.Domain.Entity;

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

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private Form form;

    public void update(QuestionAnswer questionAnswer) {
        this.description = questionAnswer.description;
    }
}