package org.example.favoriteservice.repository;

import org.example.favoriteservice.model.StarredService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StarredServiceRepository extends JpaRepository<StarredService, Long> {

    List<StarredService> findAllByUserId(Long id);

    Optional<StarredService> findByUserIdAndServiceId(Long userId, Long serviceId);

    void deleteByUserIdAndServiceId(Long userId, Long serviceId);

}
