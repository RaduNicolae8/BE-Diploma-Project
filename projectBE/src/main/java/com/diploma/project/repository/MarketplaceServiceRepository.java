package com.diploma.project.repository;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MarketplaceServiceRepository extends JpaRepository<MarketplaceService, Long> {

    List<MarketplaceService> findMarketplaceServicesByCategoryId(Long categoryId);
    List<MarketplaceService> findMarketplaceServiceByUserId(Long userId);
    @Query("SELECT s FROM MarketplaceService s WHERE CONCAT(s.title, ' ', s.tags) LIKE %?1%")
    List<MarketplaceService> search(String search);
}
