package com.web_development_class.formulate_backend.Domain.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "\"user\"")
@Table(name = "\"user\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Form> createdForms;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<FormAnswer> formAnswers;

    public void update(User user) {
        this.login = user.login;
        this.password = user.password;
    }
}
