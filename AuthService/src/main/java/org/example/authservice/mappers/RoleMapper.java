package org.example.authservice.mappers;

import org.example.authservice.dtos.RoleDTO;
import org.example.authservice.models.Role;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@Component
public interface RoleMapper extends GenericMapper<Role, RoleDTO> {
}
