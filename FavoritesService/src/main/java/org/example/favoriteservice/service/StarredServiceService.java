package org.example.favoriteservice.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.favoriteservice.dto.MarketplaceServiceDTO;
import org.example.favoriteservice.dto.StarredServiceDTO;
import org.example.favoriteservice.exception.CustomException;
import org.example.favoriteservice.feingclients.MarketplaceServiceClient;
import org.example.favoriteservice.feingclients.MarketplaceUserClient;
import org.example.favoriteservice.mapper.StarredServiceMapper;
import org.example.favoriteservice.model.StarredService;
import org.example.favoriteservice.repository.StarredServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class StarredServiceService  {

    private final StarredServiceRepository repository;
    private final StarredServiceMapper mapper;
    private final MarketplaceUserClient userClient;
    private final MarketplaceServiceClient serviceClient;

    public StarredServiceService(
            StarredServiceRepository repository,
            StarredServiceMapper mapper,
            MarketplaceUserClient userClient,
            MarketplaceServiceClient serviceClient
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.userClient = userClient;
        this.serviceClient = serviceClient;
    }

    public StarredServiceDTO update(StarredServiceDTO starredServiceDTO){
        log.debug("Update StarredService {}", starredServiceDTO.toString());
        StarredService starredService = mapper.toEntity(starredServiceDTO);

        Optional<StarredService> byId = repository.findById(starredService.getId());
        if (byId.isEmpty()) {
            throw new CustomException("StarredService with id " + starredService.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        StarredService save = repository.save(starredService);
        log.debug("Updated starredService with id {}", save.getId());
        return mapper.toDTO(save);
    }



    public StarredServiceDTO saveRequest(Long serviceId, Long userId){
        try {
            userClient.findById(userId);
            serviceClient.findById(serviceId);
        } catch (Exception e) {
            throw new CustomException(
                    "User sau Service nu există",
                    HttpStatus.BAD_REQUEST,
                    HttpStatus.BAD_REQUEST.value()
            );
        }
        Optional<StarredService> existing = repository.findByUserIdAndServiceId(userId, serviceId);
        if (existing.isPresent()) {
            return mapper.toDTO(existing.get());
        }

        StarredService entity = new StarredService(null, userId, serviceId);
        StarredService saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Transactional
    public void deleteStarredService(Long serviceId, Long userId) {
        repository.deleteByUserIdAndServiceId(serviceId, userId);
    }

    public List<MarketplaceServiceDTO> findAllByUserId(Long userId){
        List<StarredServiceDTO> starredServiceDTOS = repository.findAllByUserId(userId)
                .stream()
                .map(mapper::toDTO)
                .toList();

        List<MarketplaceServiceDTO> list = new ArrayList<>();
        for(StarredServiceDTO starredServiceDTO : starredServiceDTOS){
            try {
                MarketplaceServiceDTO serviceDTO = serviceClient.findById(starredServiceDTO.getServiceId());
                list.add(serviceDTO);
            } catch (Exception e) {
                log.warn("Service not found for id {}", starredServiceDTO.getServiceId());
            }
        }
        return list;
    }
}
