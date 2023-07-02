package com.diploma.project.repository;

import com.diploma.project.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findImagesByMarketplaceService_Id(Long id);
}
