package com.web_development_class.formulate_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_development_class.formulate_backend.Domain.Entity.Form;

public interface FormRepository extends JpaRepository<Form, Long> {}