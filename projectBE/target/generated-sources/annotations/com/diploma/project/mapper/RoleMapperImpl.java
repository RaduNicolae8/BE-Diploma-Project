package com.diploma.project.mapper;

import com.diploma.project.dto.RoleDTO;
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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( DTO.getId() );
        role.setRoleName( DTO.getRoleName() );

        return role;
    }

    @Override
    public RoleDTO toDTO(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( entity.getId() );
        roleDTO.setRoleName( entity.getRoleName() );

        return roleDTO;
    }

    @Override
    public List<Role> toEntity(List<RoleDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( DTOs.size() );
        for ( RoleDTO roleDTO : DTOs ) {
            list.add( toEntity( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDTO(List<Role> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( entities.size() );
        for ( Role role : entities ) {
            list.add( toDTO( role ) );
        }

        return list;
    }
}
