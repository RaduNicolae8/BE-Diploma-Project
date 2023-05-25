package com.diploma.project.mapper;

import com.diploma.project.dto.HistoryDTO;
import com.diploma.project.model.History;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T21:46:06+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public History toEntity(HistoryDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        History history = new History();

        history.setId( DTO.getId() );

        return history;
    }

    @Override
    public HistoryDTO toDTO(History entity) {
        if ( entity == null ) {
            return null;
        }

        HistoryDTO historyDTO = new HistoryDTO();

        historyDTO.setId( entity.getId() );

        return historyDTO;
    }

    @Override
    public List<History> toEntity(List<HistoryDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<History> list = new ArrayList<History>( DTOs.size() );
        for ( HistoryDTO historyDTO : DTOs ) {
            list.add( toEntity( historyDTO ) );
        }

        return list;
    }

    @Override
    public List<HistoryDTO> toDTO(List<History> entities) {
        if ( entities == null ) {
            return null;
        }

        List<HistoryDTO> list = new ArrayList<HistoryDTO>( entities.size() );
        for ( History history : entities ) {
            list.add( toDTO( history ) );
        }

        return list;
    }
}
