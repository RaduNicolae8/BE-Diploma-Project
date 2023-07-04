package com.diploma.project.repository;

import com.diploma.project.model.Images;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Transactional
public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findImagesByMarketplaceService_Id(Long id);
    List<Images> deleteAllByMarketplaceServiceId(Long id);
}
