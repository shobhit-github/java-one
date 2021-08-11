package com.learning.springboot.dao;

import com.learning.springboot.entities.Union;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnionRepository extends JpaRepository<Union, Long> {

    public boolean existsByWebsite(String domain);
}
