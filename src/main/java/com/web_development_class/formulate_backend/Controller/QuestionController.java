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

import com.web_development_class.formulate_backend.Domain.Entity.Question;
import com.web_development_class.formulate_backend.Service.QuestionService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/v1/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
        
    @Autowired
    private QuestionService service;

    @GetMapping
    public ResponseEntity<List<Question>> findAll() {
        List<Question> questions = service.findAll();
        return ResponseEntity.ok().body(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        Question question = service.findById(id);
        return ResponseEntity.ok().body(question);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Question> create(@RequestBody Question newQuestion) {
        Question question = service.create(newQuestion);
        return ResponseEntity.ok().body(question);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Question> updatePut(@RequestBody Question updatedQuestion) {
        Question question = service.update(updatedQuestion);
        return ResponseEntity.ok().body(question);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<Question> updatePatch(@RequestBody Question updatedQuestion) {
        Question question = service.update(updatedQuestion);
        return ResponseEntity.ok().body(question);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("Question deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}