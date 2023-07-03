package com.diploma.project.mapper;

import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.model.StarredService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-03T18:24:03+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class StarredServiceMapperImpl implements StarredServiceMapper {

    @Override
    public StarredService toEntity(StarredServiceDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        StarredService starredService = new StarredService();

        starredService.setId( DTO.getId() );
        starredService.setMarketplaceUser( DTO.getMarketplaceUser() );

        return starredService;
    }

    @Override
    public StarredServiceDTO toDTO(StarredService entity) {
        if ( entity == null ) {
            return null;
        }

        StarredServiceDTO starredServiceDTO = new StarredServiceDTO();

        starredServiceDTO.setId( entity.getId() );
        starredServiceDTO.setMarketplaceUser( entity.getMarketplaceUser() );

        return starredServiceDTO;
    }

    @Override
    public List<StarredService> toEntity(List<StarredServiceDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<StarredService> list = new ArrayList<StarredService>( DTOs.size() );
        for ( StarredServiceDTO starredServiceDTO : DTOs ) {
            list.add( toEntity( starredServiceDTO ) );
        }

        return list;
    }

    @Override
    public List<StarredServiceDTO> toDTO(List<StarredService> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StarredServiceDTO> list = new ArrayList<StarredServiceDTO>( entities.size() );
        for ( StarredService starredService : entities ) {
            list.add( toDTO( starredService ) );
        }

        return list;
    }
}
