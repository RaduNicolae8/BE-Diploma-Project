package com.diploma.project.repository;

import com.diploma.project.model.MarketplaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketplaceUserRepository extends JpaRepository<MarketplaceUser, Long> {
}
