package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web_development_class.formulate_backend.Domain.Entity.Question;
import com.web_development_class.formulate_backend.Repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public List<Question> findAll() {
        List<Question> students = repository.findAll();
        return students;
    }

    public Question findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found"));
    }

    public Question create(Question question) {
        return repository.save(question);
    }

    public Question update(Question updatedQuestion) {
        Question question = repository.findById(updatedQuestion.getId()).orElseThrow(() -> new IllegalArgumentException("Question not found"));
        question.update(updatedQuestion);
        return repository.save(question);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found"));
        repository.deleteById(id);
    }
}