package com.diploma.project.mapper;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-06T16:38:13+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class MarketplaceServiceMapperImpl implements MarketplaceServiceMapper {

    @Override
    public MarketplaceService toEntity(MarketplaceServiceDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        MarketplaceService marketplaceService = new MarketplaceService();

        marketplaceService.setId( DTO.getId() );
        marketplaceService.setPrice( DTO.getPrice() );
        marketplaceService.setName( DTO.getName() );
        marketplaceService.setDescription( DTO.getDescription() );
        marketplaceService.setIsGeneratedBySeller( DTO.getIsGeneratedBySeller() );
        marketplaceService.setDateOfCreation( DTO.getDateOfCreation() );
        marketplaceService.setCategory( DTO.getCategory() );
        marketplaceService.setServiceType( DTO.getServiceType() );
        marketplaceService.setUser( DTO.getUser() );

        return marketplaceService;
    }

    @Override
    public MarketplaceServiceDTO toDTO(MarketplaceService entity) {
        if ( entity == null ) {
            return null;
        }

        MarketplaceServiceDTO marketplaceServiceDTO = new MarketplaceServiceDTO();

        marketplaceServiceDTO.setId( entity.getId() );
        marketplaceServiceDTO.setPrice( entity.getPrice() );
        marketplaceServiceDTO.setName( entity.getName() );
        marketplaceServiceDTO.setDescription( entity.getDescription() );
        marketplaceServiceDTO.setIsGeneratedBySeller( entity.getIsGeneratedBySeller() );
        marketplaceServiceDTO.setDateOfCreation( entity.getDateOfCreation() );
        marketplaceServiceDTO.setCategory( entity.getCategory() );
        marketplaceServiceDTO.setServiceType( entity.getServiceType() );
        marketplaceServiceDTO.setUser( entity.getUser() );

        return marketplaceServiceDTO;
    }

    @Override
    public List<MarketplaceService> toEntity(List<MarketplaceServiceDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<MarketplaceService> list = new ArrayList<MarketplaceService>( DTOs.size() );
        for ( MarketplaceServiceDTO marketplaceServiceDTO : DTOs ) {
            list.add( toEntity( marketplaceServiceDTO ) );
        }

        return list;
    }

    @Override
    public List<MarketplaceServiceDTO> toDTO(List<MarketplaceService> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MarketplaceServiceDTO> list = new ArrayList<MarketplaceServiceDTO>( entities.size() );
        for ( MarketplaceService marketplaceService : entities ) {
            list.add( toDTO( marketplaceService ) );
        }

        return list;
    }
}
