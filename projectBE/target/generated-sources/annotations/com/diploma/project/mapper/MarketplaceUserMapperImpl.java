package com.diploma.project.mapper;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.dto.RoleDTO;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-04T03:53:00+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MarketplaceUserMapperImpl implements MarketplaceUserMapper {

    @Override
    public MarketplaceUser toEntity(MarketplaceUserDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        MarketplaceUser marketplaceUser = new MarketplaceUser();

        marketplaceUser.setId( DTO.getId() );
        marketplaceUser.setEmail( DTO.getEmail() );
        marketplaceUser.setPassword( DTO.getPassword() );
        marketplaceUser.setFirstName( DTO.getFirstName() );
        marketplaceUser.setLastName( DTO.getLastName() );
        marketplaceUser.setDescription( DTO.getDescription() );
        marketplaceUser.setImg( DTO.getImg() );
        marketplaceUser.setIsSeller( DTO.getIsSeller() );
        marketplaceUser.setCountry( DTO.getCountry() );
        marketplaceUser.setPhoneNumber( DTO.getPhoneNumber() );
        marketplaceUser.setResetPasswordToken( DTO.getResetPasswordToken() );
        marketplaceUser.setRole( roleDTOToRole( DTO.getRole() ) );
        marketplaceUser.setLanguages( DTO.getLanguages() );

        return marketplaceUser;
    }

    @Override
    public MarketplaceUserDTO toDTO(MarketplaceUser entity) {
        if ( entity == null ) {
            return null;
        }

        MarketplaceUserDTO marketplaceUserDTO = new MarketplaceUserDTO();

        marketplaceUserDTO.setId( entity.getId() );
        marketplaceUserDTO.setEmail( entity.getEmail() );
        marketplaceUserDTO.setPassword( entity.getPassword() );
        marketplaceUserDTO.setFirstName( entity.getFirstName() );
        marketplaceUserDTO.setLastName( entity.getLastName() );
        marketplaceUserDTO.setCountry( entity.getCountry() );
        marketplaceUserDTO.setPhoneNumber( entity.getPhoneNumber() );
        marketplaceUserDTO.setDescription( entity.getDescription() );
        marketplaceUserDTO.setImg( entity.getImg() );
        marketplaceUserDTO.setIsSeller( entity.getIsSeller() );
        marketplaceUserDTO.setRole( roleToRoleDTO( entity.getRole() ) );
        marketplaceUserDTO.setResetPasswordToken( entity.getResetPasswordToken() );
        marketplaceUserDTO.setLanguages( entity.getLanguages() );

        return marketplaceUserDTO;
    }

    @Override
    public List<MarketplaceUser> toEntity(List<MarketplaceUserDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<MarketplaceUser> list = new ArrayList<MarketplaceUser>( DTOs.size() );
        for ( MarketplaceUserDTO marketplaceUserDTO : DTOs ) {
            list.add( toEntity( marketplaceUserDTO ) );
        }

        return list;
    }

    @Override
    public List<MarketplaceUserDTO> toDTO(List<MarketplaceUser> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MarketplaceUserDTO> list = new ArrayList<MarketplaceUserDTO>( entities.size() );
        for ( MarketplaceUser marketplaceUser : entities ) {
            list.add( toDTO( marketplaceUser ) );
        }

        return list;
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

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }
}
