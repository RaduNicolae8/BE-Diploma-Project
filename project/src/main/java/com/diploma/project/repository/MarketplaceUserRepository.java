package com.diploma.project.repository;

import com.diploma.project.model.MarketplaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketplaceUserRepository extends JpaRepository<MarketplaceUser, Long> {
    Optional<MarketplaceUser> findByEmail(String email);
    Optional<MarketplaceUser> findByResetPasswordToken(String resetPasswordToken);
}
