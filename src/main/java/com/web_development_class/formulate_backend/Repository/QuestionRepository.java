package com.web_development_class.formulate_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Domain.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  void deleteAllByForm(Form form);

  List<Question> findAllByForm(Form form);
}
