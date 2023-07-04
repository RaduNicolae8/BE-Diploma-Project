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

import java.util.ArrayList;
import java.util.List;
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
                marketplaceUserService.findById(serviceRequest.getUserId()),
                serviceRequest.getIsRequest()
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

    public List<MarketplaceServiceDTO> getOrderAndSortByCategory(int min, int max, String sort, Long categoryId ){
        List<MarketplaceServiceDTO> list =  getGenericMapper().toDTO( ((MarketplaceServiceRepository) getJpaRepository()).findMarketplaceServicesByCategoryId(categoryId));
        List<MarketplaceServiceDTO> newList = new ArrayList<>();
        for (MarketplaceServiceDTO marketplaceServiceDTO : list) {
            if (marketplaceServiceDTO.getPrice() >= min && marketplaceServiceDTO.getPrice() <= max) {
                newList.add(marketplaceServiceDTO);
            }
        }
        if (sort.equalsIgnoreCase("cheapest")){
            newList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        } else if (sort.equalsIgnoreCase("expensive")){
            newList.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
        } else if (sort.equalsIgnoreCase("newest")){
            newList.sort((o1, o2) -> (int) (o2.getId() - o1.getId()));
        } else if (sort.equalsIgnoreCase("oldest")){
            newList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        }
        return newList;
    }

    public List<MarketplaceServiceDTO> getMarketplaceServiceByUserId(Long userId){
        return getGenericMapper().toDTO( ((MarketplaceServiceRepository) getJpaRepository()).findMarketplaceServiceByUserId(userId));
    }
}
