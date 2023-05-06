package com.diploma.project.repository;

import com.diploma.project.model.StarredService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarredServiceRepository extends JpaRepository<StarredService, Long> {
}
