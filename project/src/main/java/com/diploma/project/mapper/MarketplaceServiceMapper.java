package com.diploma.project.mapper;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MarketplaceServiceMapper extends GenericMapper<MarketplaceService, MarketplaceServiceDTO>{
}
