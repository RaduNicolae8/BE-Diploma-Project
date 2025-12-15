package org.example.authservice.mappers;

import org.example.authservice.dtos.MarketplaceUserDTO;
import org.example.authservice.models.MarketplaceUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MarketplaceUserMapper extends GenericMapper<MarketplaceUser, MarketplaceUserDTO> {
}
