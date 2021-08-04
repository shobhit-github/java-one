package com.learning.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


    public boolean existsByEmail(String email);
}
