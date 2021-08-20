package com.learning.springboot.dao;

import com.learning.springboot.entities.Temple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempleRepository extends JpaRepository<Temple, Long> {

    public boolean existsByWebsite(String domain);

    public boolean existsByEmail(String email);
}
