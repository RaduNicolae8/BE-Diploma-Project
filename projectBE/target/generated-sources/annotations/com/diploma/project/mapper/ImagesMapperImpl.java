package com.diploma.project.mapper;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.dto.ImagesDTO;
import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.dto.RoleDTO;
import com.diploma.project.model.Category;
import com.diploma.project.model.Images;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-18T15:44:57+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.17 (Microsoft)"
)
@Component
public class ImagesMapperImpl implements ImagesMapper {

    @Override
    public Images toEntity(ImagesDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Images images = new Images();

        images.setId( DTO.getId() );
        images.setUrl( DTO.getUrl() );
        images.setMarketplaceService( marketplaceServiceDTOToMarketplaceService( DTO.getMarketplaceService() ) );

        return images;
    }

    @Override
    public ImagesDTO toDTO(Images entity) {
        if ( entity == null ) {
            return null;
        }

        ImagesDTO imagesDTO = new ImagesDTO();

        imagesDTO.setId( entity.getId() );
        imagesDTO.setMarketplaceService( marketplaceServiceToMarketplaceServiceDTO( entity.getMarketplaceService() ) );
        imagesDTO.setUrl( entity.getUrl() );

        return imagesDTO;
    }

    @Override
    public List<Images> toEntity(List<ImagesDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<Images> list = new ArrayList<Images>( DTOs.size() );
        for ( ImagesDTO imagesDTO : DTOs ) {
            list.add( toEntity( imagesDTO ) );
        }

        return list;
    }

    @Override
    public List<ImagesDTO> toDTO(List<Images> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ImagesDTO> list = new ArrayList<ImagesDTO>( entities.size() );
        for ( Images images : entities ) {
            list.add( toDTO( images ) );
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

    protected MarketplaceService marketplaceServiceDTOToMarketplaceService(MarketplaceServiceDTO marketplaceServiceDTO) {
        if ( marketplaceServiceDTO == null ) {
            return null;
        }

        MarketplaceService marketplaceService = new MarketplaceService();

        marketplaceService.setId( marketplaceServiceDTO.getId() );
        marketplaceService.setPrice( marketplaceServiceDTO.getPrice() );
        marketplaceService.setTitle( marketplaceServiceDTO.getTitle() );
        marketplaceService.setDescription( marketplaceServiceDTO.getDescription() );
        marketplaceService.setShortDescription( marketplaceServiceDTO.getShortDescription() );
        marketplaceService.setCoverImage( marketplaceServiceDTO.getCoverImage() );
        marketplaceService.setTags( marketplaceServiceDTO.getTags() );
        marketplaceService.setCategory( categoryDTOToCategory( marketplaceServiceDTO.getCategory() ) );
        marketplaceService.setUser( marketplaceUserDTOToMarketplaceUser( marketplaceServiceDTO.getUser() ) );
        marketplaceService.setIsRequest( marketplaceServiceDTO.getIsRequest() );

        return marketplaceService;
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

    protected MarketplaceServiceDTO marketplaceServiceToMarketplaceServiceDTO(MarketplaceService marketplaceService) {
        if ( marketplaceService == null ) {
            return null;
        }

        MarketplaceServiceDTO marketplaceServiceDTO = new MarketplaceServiceDTO();

        marketplaceServiceDTO.setId( marketplaceService.getId() );
        marketplaceServiceDTO.setPrice( marketplaceService.getPrice() );
        marketplaceServiceDTO.setTitle( marketplaceService.getTitle() );
        marketplaceServiceDTO.setDescription( marketplaceService.getDescription() );
        marketplaceServiceDTO.setShortDescription( marketplaceService.getShortDescription() );
        marketplaceServiceDTO.setCoverImage( marketplaceService.getCoverImage() );
        marketplaceServiceDTO.setTags( marketplaceService.getTags() );
        marketplaceServiceDTO.setCategory( categoryToCategoryDTO( marketplaceService.getCategory() ) );
        marketplaceServiceDTO.setUser( marketplaceUserToMarketplaceUserDTO( marketplaceService.getUser() ) );
        marketplaceServiceDTO.setIsRequest( marketplaceService.getIsRequest() );

        return marketplaceServiceDTO;
    }
}
