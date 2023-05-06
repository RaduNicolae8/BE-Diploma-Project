package com.diploma.project.mapper;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.model.MarketplaceUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MarketplaceUserMapper extends GenericMapper<MarketplaceUser, MarketplaceUserDTO>{
}
