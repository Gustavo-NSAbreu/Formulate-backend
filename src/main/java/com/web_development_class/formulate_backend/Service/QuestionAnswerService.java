package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Domain.Entity.QuestionAnswer;
import com.web_development_class.formulate_backend.Repository.QuestionAnswerRepository;

@Service
public class QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository repository;

    public List<QuestionAnswer> findAllByForm(Form form) {
        List<QuestionAnswer> students = repository.findAllByForm(form);
        return students;
    }

    public QuestionAnswer create(QuestionAnswer questionAnswer) {
        return repository.save(questionAnswer);
    }
}