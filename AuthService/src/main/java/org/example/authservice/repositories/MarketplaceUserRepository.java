package org.example.authservice.repositories;

import org.example.authservice.models.MarketplaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketplaceUserRepository extends JpaRepository<MarketplaceUser, Long> {
    Optional<MarketplaceUser> findByEmail(String email);
    Optional<MarketplaceUser> findByResetPasswordToken(String resetPasswordToken);

}
