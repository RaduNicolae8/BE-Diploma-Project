package com.diploma.project.mapper;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.dto.RoleDTO;
import com.diploma.project.model.Category;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-04T03:52:59+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
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
        marketplaceService.setTitle( DTO.getTitle() );
        marketplaceService.setDescription( DTO.getDescription() );
        marketplaceService.setShortDescription( DTO.getShortDescription() );
        marketplaceService.setCoverImage( DTO.getCoverImage() );
        marketplaceService.setTags( DTO.getTags() );
        marketplaceService.setCategory( categoryDTOToCategory( DTO.getCategory() ) );
        marketplaceService.setUser( marketplaceUserDTOToMarketplaceUser( DTO.getUser() ) );
        marketplaceService.setIsRequest( DTO.getIsRequest() );

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
        marketplaceServiceDTO.setTitle( entity.getTitle() );
        marketplaceServiceDTO.setDescription( entity.getDescription() );
        marketplaceServiceDTO.setShortDescription( entity.getShortDescription() );
        marketplaceServiceDTO.setCoverImage( entity.getCoverImage() );
        marketplaceServiceDTO.setTags( entity.getTags() );
        marketplaceServiceDTO.setCategory( categoryToCategoryDTO( entity.getCategory() ) );
        marketplaceServiceDTO.setUser( marketplaceUserToMarketplaceUserDTO( entity.getUser() ) );
        marketplaceServiceDTO.setIsRequest( entity.getIsRequest() );

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

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );
        category.setDescription( categoryDTO.getDescription() );

        return category;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setRoleName( roleDTO.getRoleName() );

        return role;
    }

    protected MarketplaceUser marketplaceUserDTOToMarketplaceUser(MarketplaceUserDTO marketplaceUserDTO) {
        if ( marketplaceUserDTO == null ) {
            return null;
        }

        MarketplaceUser marketplaceUser = new MarketplaceUser();

        marketplaceUser.setId( marketplaceUserDTO.getId() );
        marketplaceUser.setEmail( marketplaceUserDTO.getEmail() );
        marketplaceUser.setPassword( marketplaceUserDTO.getPassword() );
        marketplaceUser.setFirstName( marketplaceUserDTO.getFirstName() );
        marketplaceUser.setLastName( marketplaceUserDTO.getLastName() );
        marketplaceUser.setDescription( marketplaceUserDTO.getDescription() );
        marketplaceUser.setImg( marketplaceUserDTO.getImg() );
        marketplaceUser.setIsSeller( marketplaceUserDTO.getIsSeller() );
        marketplaceUser.setCountry( marketplaceUserDTO.getCountry() );
        marketplaceUser.setPhoneNumber( marketplaceUserDTO.getPhoneNumber() );
        marketplaceUser.setResetPasswordToken( marketplaceUserDTO.getResetPasswordToken() );
        marketplaceUser.setRole( roleDTOToRole( marketplaceUserDTO.getRole() ) );
        marketplaceUser.setLanguages( marketplaceUserDTO.getLanguages() );

        return marketplaceUser;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setDescription( category.getDescription() );

        return categoryDTO;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }

    protected MarketplaceUserDTO marketplaceUserToMarketplaceUserDTO(MarketplaceUser marketplaceUser) {
        if ( marketplaceUser == null ) {
            return null;
        }

        MarketplaceUserDTO marketplaceUserDTO = new MarketplaceUserDTO();

        marketplaceUserDTO.setId( marketplaceUser.getId() );
        marketplaceUserDTO.setEmail( marketplaceUser.getEmail() );
        marketplaceUserDTO.setPassword( marketplaceUser.getPassword() );
        marketplaceUserDTO.setFirstName( marketplaceUser.getFirstName() );
        marketplaceUserDTO.setLastName( marketplaceUser.getLastName() );
        marketplaceUserDTO.setCountry( marketplaceUser.getCountry() );
        marketplaceUserDTO.setPhoneNumber( marketplaceUser.getPhoneNumber() );
        marketplaceUserDTO.setDescription( marketplaceUser.getDescription() );
        marketplaceUserDTO.setImg( marketplaceUser.getImg() );
        marketplaceUserDTO.setIsSeller( marketplaceUser.getIsSeller() );
        marketplaceUserDTO.setRole( roleToRoleDTO( marketplaceUser.getRole() ) );
        marketplaceUserDTO.setResetPasswordToken( marketplaceUser.getResetPasswordToken() );
        marketplaceUserDTO.setLanguages( marketplaceUser.getLanguages() );

        return marketplaceUserDTO;
    }
}
