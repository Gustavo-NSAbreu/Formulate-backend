package com.web_development_class.formulate_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web_development_class.formulate_backend.Domain.Entity.User;
import com.web_development_class.formulate_backend.Service.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<User> create(@RequestBody User newUser) {
        User user = service.create(newUser);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<User> updatePut(@RequestBody User updatedUser) {
        User user = service.update(updatedUser);
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<User> updatePatch(@RequestBody User updatedUser) {
        User user = service.update(updatedUser);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("User deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
