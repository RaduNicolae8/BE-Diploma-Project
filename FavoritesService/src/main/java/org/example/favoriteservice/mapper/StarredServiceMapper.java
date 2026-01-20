package org.example.favoriteservice.mapper;

import org.example.favoriteservice.dto.StarredServiceDTO;
import org.example.favoriteservice.model.StarredService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StarredServiceMapper {
	StarredServiceDTO toDTO(StarredService entity);
	StarredService toEntity(StarredServiceDTO dto);
}
