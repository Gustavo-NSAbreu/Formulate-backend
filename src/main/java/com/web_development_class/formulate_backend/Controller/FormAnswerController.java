package com.web_development_class.formulate_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_development_class.formulate_backend.Domain.Entity.FormAnswer;
import com.web_development_class.formulate_backend.Service.FormAnswerService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/v1/formAnswers")
@CrossOrigin(origins = "*")
public class FormAnswerController {
        
    @Autowired
    private FormAnswerService service;

    @GetMapping
    public ResponseEntity<List<FormAnswer>> findAll() {
        List<FormAnswer> formAnswers = service.findAll();
        return ResponseEntity.ok().body(formAnswers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormAnswer> findById(@PathVariable Long id) {
        FormAnswer formAnswer = service.findById(id);
        return ResponseEntity.ok().body(formAnswer);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FormAnswer> create(@RequestBody FormAnswer newFormAnswer) {
        FormAnswer formAnswer = service.create(newFormAnswer);
        return ResponseEntity.ok().body(formAnswer);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("FormAnswer deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}