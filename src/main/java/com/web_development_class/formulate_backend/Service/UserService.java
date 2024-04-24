package com.web_development_class.formulate_backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web_development_class.formulate_backend.Domain.Entity.User;
import com.web_development_class.formulate_backend.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }

    public User findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(User updatedUser) {
        User user = repository.findById(updatedUser.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.update(updatedUser);
        return repository.save(user);
    }

    public void delete(Long userId) {
        repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        repository.deleteById(userId);
    }

}
