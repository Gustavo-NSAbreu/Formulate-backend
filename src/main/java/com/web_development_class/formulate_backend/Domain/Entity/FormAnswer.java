package com.web_development_class.formulate_backend.Domain.Entity;

import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity(name = "form_answer")
@Table(name = "form_answer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "\"user\"", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "form", nullable = false)
    private Form form;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @JsonIgnore
    @OneToMany(mappedBy = "formAnswer")
    private Set<QuestionAnswer> questionAnswers;
}
