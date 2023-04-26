package com.diploma.project.mapper;

import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.model.StarredService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StarredServiceMapper extends GenericMapper<StarredService, StarredServiceDTO>{
}
