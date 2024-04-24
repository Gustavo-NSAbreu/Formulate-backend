package com.web_development_class.formulate_backend.Domain.Entity;

import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web_development_class.formulate_backend.Domain.DTO.FormDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Entity(name = "form")
@Table(name = "form")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    
    @ManyToOne
    @JoinColumn(name = "\"user\"", nullable = false)
    private User user;
    
    @JsonIgnore
    @OneToMany(mappedBy = "form")
    private Set<FormAnswer> formAnswers;

    @JsonIgnore
    @OneToMany(mappedBy = "form", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Question> questions;

    public Form(FormDTO form) {
        this.id = form.id();
        this.name = form.name();
        this.description = form.description();
        this.createdAt = form.createdAt();
        this.user = form.user();
    }

    public void update(Form form) {
        this.name = form.name;
        this.description = form.name;
    }
}
