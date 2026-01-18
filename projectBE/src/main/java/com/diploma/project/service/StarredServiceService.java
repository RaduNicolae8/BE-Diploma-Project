//package com.diploma.project.service;
//
//import com.diploma.project.dto.MarketplaceServiceDTO;
//import com.diploma.project.dto.StarredServiceDTO;
//import com.diploma.project.exception.CustomException;
//import com.diploma.project.mapper.StarredServiceMapper;
//import com.diploma.project.model.StarredService;
//import com.diploma.project.repository.StarredServiceRepository;
//import jakarta.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Slf4j
//@Transactional
//public class StarredServiceService extends GenericService<StarredService, StarredServiceDTO> {
//
//    private final MarketplaceServiceService marketplaceServiceService;
//    private final MarketplaceUserService marketplaceUserService;
//
//    @Autowired
//    StarredServiceService(StarredServiceRepository starredServiceRepository, StarredServiceMapper starredServiceMapper, MarketplaceServiceService marketplaceServiceService, MarketplaceUserService marketplaceUserService) {
//        super(starredServiceRepository, starredServiceMapper);
//        this.marketplaceServiceService = marketplaceServiceService;
//        this.marketplaceUserService = marketplaceUserService;
//    }
//
//    public StarredServiceDTO update(StarredServiceDTO starredServiceDTO){
//        log.debug("Update StarredService {}", starredServiceDTO.toString());
//        StarredService starredService = getGenericMapper().toEntity(starredServiceDTO);
//        Optional<StarredService> byId = getJpaRepository().findById(starredService.getId());
//        if (byId.isEmpty()) {
//            throw new CustomException("StarredService with id " + starredService.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
//        }
//        StarredService save = getJpaRepository().save(starredService);
//        log.debug("Updated starredService with id {}", save.getId());
//        return getGenericMapper().toDTO(save);
//    }
//
//    public StarredServiceDTO saveRequest(Long serviceId, Long userId){
//        StarredServiceDTO starredServiceDTO = new StarredServiceDTO(
//                null,
//                marketplaceUserService.findById(userId),
//                marketplaceServiceService.findById(serviceId)
//        );
//        for(StarredServiceDTO starredServiceDTO1 : findAll()){
//            if(starredServiceDTO1.getMarketplaceService().getId().equals(serviceId) && starredServiceDTO1.getMarketplaceUser().getId().equals(userId)){
//                return starredServiceDTO1;
//            }
//        }
//        return save(starredServiceDTO);
//    }
//
//    public void deleteStarredService(Long serviceId, Long userId){
//        ((StarredServiceRepository) getJpaRepository()).deleteStarredServiceByMarketplaceServiceIdAndMarketplaceUserId(serviceId, userId);
//    }
//
//    public List<MarketplaceServiceDTO> findAllByUserId(Long userId){
//        List<StarredServiceDTO> starredServiceDTOS = getGenericMapper().toDTO(((StarredServiceRepository) getJpaRepository()).findAllByMarketplaceUser_Id(userId));
//        List<MarketplaceServiceDTO> list = new ArrayList<>();
//        for(StarredServiceDTO starredServiceDTO : starredServiceDTOS){
//            list.add(starredServiceDTO.getMarketplaceService());
//        }
//        return list;
//        //        return getGenericMapper().toDTO(((StarredServiceRepository) getJpaRepository()).findAllByMarketplaceUser_Id(userId));
//    }
//}
