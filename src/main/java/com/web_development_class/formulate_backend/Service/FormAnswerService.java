package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.formulate_backend.Domain.DTO.FormAnswerCreationDTO;
import com.web_development_class.formulate_backend.Domain.DTO.FormAnswerDTO;
import com.web_development_class.formulate_backend.Domain.DTO.QuestionAnswerDTO;
import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;
import com.web_development_class.formulate_backend.Domain.Entity.QuestionAnswer;
import com.web_development_class.formulate_backend.Repository.FormAnswerRepository;
import com.web_development_class.formulate_backend.Repository.QuestionAnswerRepository;

@Service
public class FormAnswerService {
    @Autowired
    private FormAnswerRepository repository;

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public List<FormAnswer> findAll() {
        List<FormAnswer> students = repository.findAll();
        return students;
    }

    public FormAnswerDTO findById(Long id) {
        FormAnswer formAnswer = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("FormAnswer not found"));
        List<QuestionAnswer> questionAnswers = questionAnswerRepository.findAllByFormAnswer(formAnswer);
        return new FormAnswerDTO(formAnswer, questionAnswers);
    }

    public FormAnswer createWithAnswers(FormAnswerCreationDTO request) {
        for (QuestionAnswerDTO questionAnswer : request.questionAnswers()) {
            QuestionAnswer newQuestionAnswer = new QuestionAnswer(questionAnswer, request.formAnswer().getForm());
            questionAnswerRepository.save(newQuestionAnswer);
        }
        return repository.save(request.formAnswer());
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("FormAnswer not found"));
        repository.deleteById(id);
    }
}