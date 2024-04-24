package com.web_development_class.formulate_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_development_class.formulate_backend.Domain.DTO.FormDTO;
import com.web_development_class.formulate_backend.Domain.DTO.FormRequestDTO;
import com.web_development_class.formulate_backend.Domain.DTO.FormResponseDTO;
import com.web_development_class.formulate_backend.Domain.Entity.Form;
import com.web_development_class.formulate_backend.Service.FormService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/v1/forms")
@CrossOrigin(origins = "*")
public class FormController {
        
    @Autowired
    private FormService service;

    @GetMapping
    public ResponseEntity<List<Form>> findAll() {
        List<Form> forms = service.findAll();
        return ResponseEntity.ok().body(forms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Form> findFormWithQuestions(@PathVariable Long id) {
        Form form = service.findById(id);
        return ResponseEntity.ok().body(form);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Form> create(@RequestBody Form newForm) {
        Form form = service.create(newForm);
        return ResponseEntity.ok().body(form);
    }

    @PostMapping("/questions")
    @Transactional
    public ResponseEntity<Form> createWIthQuestions(@RequestBody FormResponseDTO newForm) {
        Form form = service.createWithQuestions(newForm);
        return ResponseEntity.ok().body(form);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Form> updatePut(@RequestBody FormDTO updatedForm) {
        Form form = service.update(updatedForm);
        return ResponseEntity.ok().body(form);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<Form> updatePatch(@RequestBody FormDTO updatedForm) {
        Form form = service.update(updatedForm);
        return ResponseEntity.ok().body(form);
    }

    @PutMapping("/questions")
    @Transactional
    public ResponseEntity<Form> updateWithQuestionPut(@RequestBody FormRequestDTO updatedForm) {
        Form form = service.updateWithQuestion(updatedForm);
        return ResponseEntity.ok().body(form);
    }

    @PatchMapping("/questions")
    @Transactional
    public ResponseEntity<Form> updateWithQuestionPatch(@RequestBody FormRequestDTO updatedForm) {
        Form form = service.updateWithQuestion(updatedForm);
        return ResponseEntity.ok().body(form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("Form deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}