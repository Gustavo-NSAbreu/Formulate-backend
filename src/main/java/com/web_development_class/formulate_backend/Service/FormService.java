package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.formulate_backend.Domain.DTO.FormDTO;
import com.web_development_class.formulate_backend.Domain.DTO.FormRequestDTO;
import com.web_development_class.formulate_backend.Domain.DTO.FormResponseDTO;
import com.web_development_class.formulate_backend.Domain.DTO.QuestionDTO;
import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Domain.Entity.Question;
import com.web_development_class.formulate_backend.Repository.FormRepository;
import com.web_development_class.formulate_backend.Repository.QuestionRepository;

@Service
public class FormService {
    
    @Autowired
    private FormRepository repository;
    
    @Autowired
    private QuestionRepository questionRepository;

    public List<Form> findAll() {
        List<Form> forms = repository.findAll();
        return forms;
    }

    public List<Form> findFormWithQuestions() {
        List<Form> forms = repository.findAll();
        return forms;
    }

    public Form findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Form not found"));
    }

    public Form create(Form newForm) {
        return repository.save(newForm);
    }

    public Form createWithQuestions(FormResponseDTO newForm) {
        Form createdForm = repository.save(newForm.form());
        for (Question question : newForm.questions()) {
            question.setForm(createdForm);
            questionRepository.save(question);
        }
        return repository.save(createdForm);
    }

    public Form update(FormDTO updatedForm) {
        Form formToUpdate = new Form(updatedForm);
        Form form = repository.findById(formToUpdate.getId()).orElseThrow(() -> new IllegalArgumentException("Form not found"));
        form.update(form);
        return repository.save(form);
    }

    public Form updateWithQuestion(FormRequestDTO updatedForm) {
        Form formToUpdate = new Form(updatedForm.form());
        Form form = repository.findById(formToUpdate.getId()).orElseThrow(() -> new IllegalArgumentException("Form not found"));
        form.update(formToUpdate);
        for (QuestionDTO question : updatedForm.questions()) {
            Question questionToUpdate = new Question(question, form);
            questionRepository.save(questionToUpdate);
        }
        return repository.save(form);
    }

    public void delete(Long id) {
        Form form = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Form not found"));
        repository.deleteById(id);
        questionRepository.deleteAllByForm(form);
    }
}