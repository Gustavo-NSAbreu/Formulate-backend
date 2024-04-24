package com.web_development_class.formulate_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;

public interface FormAnswerRepository extends JpaRepository<FormAnswer, Long> {}
