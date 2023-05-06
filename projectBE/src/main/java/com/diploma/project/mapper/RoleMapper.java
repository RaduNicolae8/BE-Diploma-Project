package com.diploma.project.mapper;

import com.diploma.project.dto.RoleDTO;
import com.diploma.project.model.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoleMapper extends GenericMapper<Role, RoleDTO>{
}
