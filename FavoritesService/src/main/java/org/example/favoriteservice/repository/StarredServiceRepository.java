package org.example.favoriteservice.repository;

import org.example.favoriteservice.model.StarredService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StarredServiceRepository extends JpaRepository<StarredService, Long> {

    List<StarredService> findAllByUserId(Long userId);

    Optional<StarredService> findByUserIdAndServiceId(Long userId, Long serviceId);

    @Modifying
    @Query("DELETE FROM StarredService ss WHERE ss.serviceId = :serviceId AND ss.userId = :userId")
    void deleteByUserIdAndServiceId(@Param("serviceId") Long serviceId, @Param("userId") Long userId);

}
