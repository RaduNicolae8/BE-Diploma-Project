package com.diploma.project.service;

import com.diploma.project.dto.ImagesDTO;
import com.diploma.project.mapper.ImagesMapper;
import com.diploma.project.model.Images;
import com.diploma.project.repository.ImagesRepository;
import com.diploma.project.security.ImagesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImagesService extends GenericService<Images, ImagesDTO>{

    private final MarketplaceServiceService marketplaceServiceService;
    public ImagesService(ImagesMapper imagesMapper, ImagesRepository imagesRepository, MarketplaceServiceService marketplaceServiceService){
        super(imagesRepository,imagesMapper);
        this.marketplaceServiceService = marketplaceServiceService;
    }

    public ImagesDTO saveRequest(ImagesRequest imagesRequest){
        ImagesDTO imagesDTO = new ImagesDTO(
                null,
                marketplaceServiceService.findById(imagesRequest.getServiceId()),
                imagesRequest.getUrl()
                );
        System.out.println( marketplaceServiceService.findById(imagesRequest.getServiceId()));
        return save(imagesDTO);
    }

    public List<ImagesDTO> findImagesByMarketplaceService_Id(Long id){
        return ((ImagesMapper) getGenericMapper()).toDTO(((ImagesRepository) getJpaRepository()).findImagesByMarketplaceService_Id(id));
    }


}
