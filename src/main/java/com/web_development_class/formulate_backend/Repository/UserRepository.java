package com.web_development_class.formulate_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_development_class.formulate_backend.Domain.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
