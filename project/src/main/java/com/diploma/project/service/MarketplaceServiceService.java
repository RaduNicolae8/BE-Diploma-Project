package com.diploma.project.service;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.MarketplaceServiceMapper;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.repository.MarketplaceServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MarketplaceServiceService extends GenericService<MarketplaceService, MarketplaceServiceDTO> {

    MarketplaceServiceService(MarketplaceServiceRepository marketplaceServiceRepository, MarketplaceServiceMapper marketplaceServiceMapper) {
        super(marketplaceServiceRepository, marketplaceServiceMapper);
    }

    MarketplaceServiceDTO update(MarketplaceServiceDTO marketplaceServiceDTO) {
        log.debug("Update MarketplaceService {}", marketplaceServiceDTO.toString());
        MarketplaceService marketplaceService = getGenericMapper().toEntity(marketplaceServiceDTO);
        Optional<MarketplaceService> byId = getJpaRepository().findById(marketplaceService.getId());
        if (byId.isEmpty()) {
            throw new CustomException("MarketplaceService with id " + marketplaceService.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        MarketplaceService save = getJpaRepository().save(marketplaceService);
        log.debug("Updated marketplaceService with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }
}
