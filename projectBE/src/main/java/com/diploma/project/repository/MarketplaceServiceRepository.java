package com.diploma.project.repository;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketplaceServiceRepository extends JpaRepository<MarketplaceService, Long> {

    List<MarketplaceService> findMarketplaceServicesByCategoryId(Long categoryId);
    List<MarketplaceService> findMarketplaceServiceByUserId(Long userId);
}
