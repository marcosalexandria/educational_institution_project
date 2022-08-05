package com.example.project.domain.repositories;

import com.example.project.domain.entities.Matter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatterRepository extends JpaRepository<Matter, Long> {
}
