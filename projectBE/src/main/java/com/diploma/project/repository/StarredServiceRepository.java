//package com.diploma.project.repository;
//
//import com.diploma.project.model.StarredService;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface StarredServiceRepository extends JpaRepository<StarredService, Long> {
//    List<StarredService> findAllByMarketplaceUser_Id(Long id);
//    //StarredService deleteStarredServiceByMarketplaceServiceIdAndMarketplaceUserId(Long serviceId, Long userId);
//    @Modifying
//    @Query("DELETE FROM StarredService ss WHERE ss.marketplaceService.id = :serviceId AND ss.marketplaceUser.id = :userId")
//    void deleteStarredServiceByMarketplaceServiceIdAndMarketplaceUserId(@Param("serviceId") Long serviceId, @Param("userId") Long userId);
//
//
//}
