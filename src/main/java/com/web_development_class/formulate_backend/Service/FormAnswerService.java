package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;
import com.web_development_class.formulate_backend.Repository.FormAnswerRepository;

@Service
public class FormAnswerService {
    @Autowired
    private FormAnswerRepository repository;

    public List<FormAnswer> findAll() {
        List<FormAnswer> students = repository.findAll();
        return students;
    }

    public FormAnswer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("FormAnswer not found"));
    }

    public FormAnswer create(FormAnswer newFormAnswer) {
        return repository.save(newFormAnswer);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("FormAnswer not found"));
        repository.deleteById(id);
    }
}