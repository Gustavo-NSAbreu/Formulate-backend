package com.web_development_class.formulate_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;
import com.web_development_class.formulate_backend.Domain.Entity.QuestionAnswer;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    public List<QuestionAnswer> findAllByFormAnswer(FormAnswer formAnswer);
}
