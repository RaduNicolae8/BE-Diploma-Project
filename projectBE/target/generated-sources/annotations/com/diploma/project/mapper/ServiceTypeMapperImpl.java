package com.diploma.project.mapper;

import com.diploma.project.dto.ServiceTypeDTO;
import com.diploma.project.model.ServiceType;
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
public class ServiceTypeMapperImpl implements ServiceTypeMapper {

    @Override
    public ServiceType toEntity(ServiceTypeDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        ServiceType serviceType = new ServiceType();

        serviceType.setId( DTO.getId() );
        serviceType.setTitle( DTO.getTitle() );

        return serviceType;
    }

    @Override
    public ServiceTypeDTO toDTO(ServiceType entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceTypeDTO serviceTypeDTO = new ServiceTypeDTO();

        serviceTypeDTO.setId( entity.getId() );
        serviceTypeDTO.setTitle( entity.getTitle() );

        return serviceTypeDTO;
    }

    @Override
    public List<ServiceType> toEntity(List<ServiceTypeDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<ServiceType> list = new ArrayList<ServiceType>( DTOs.size() );
        for ( ServiceTypeDTO serviceTypeDTO : DTOs ) {
            list.add( toEntity( serviceTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<ServiceTypeDTO> toDTO(List<ServiceType> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ServiceTypeDTO> list = new ArrayList<ServiceTypeDTO>( entities.size() );
        for ( ServiceType serviceType : entities ) {
            list.add( toDTO( serviceType ) );
        }

        return list;
    }
}
