package com.diploma.project.service;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.MarketplaceServiceMapper;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.repository.MarketplaceServiceRepository;
import com.diploma.project.security.ServiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MarketplaceServiceService extends GenericService<MarketplaceService, MarketplaceServiceDTO> {

    private final CategoryService categoryService;
    private final MarketplaceUserService marketplaceUserService;
    MarketplaceServiceService(MarketplaceServiceRepository marketplaceServiceRepository, MarketplaceServiceMapper marketplaceServiceMapper, CategoryService categoryService, MarketplaceUserService marketplaceUserService) {
        super(marketplaceServiceRepository, marketplaceServiceMapper);
        this.categoryService = categoryService;
        this.marketplaceUserService = marketplaceUserService;
    }

    public MarketplaceServiceDTO saveRequest(ServiceRequest serviceRequest){
        MarketplaceServiceDTO marketplaceServiceDTO = new MarketplaceServiceDTO(
                null,
                serviceRequest.getPrice(),
                serviceRequest.getTitle(),
                serviceRequest.getDescription(),
                serviceRequest.getShortDescription(),
                serviceRequest.getCoverImage(),
                serviceRequest.getTags(),
                categoryService.findById(serviceRequest.getCategoryId()),
                marketplaceUserService.findById(serviceRequest.getUserId())
                );
        return save(marketplaceServiceDTO);
    }

    public MarketplaceServiceDTO update(MarketplaceServiceDTO marketplaceServiceDTO) {
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
