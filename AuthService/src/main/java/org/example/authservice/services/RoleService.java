package org.example.authservice.services;

import lombok.extern.slf4j.Slf4j;
import org.example.authservice.dtos.RoleDTO;
import org.example.authservice.exceptions.CustomException;
import org.example.authservice.mappers.RoleMapper;
import org.example.authservice.models.Role;
import org.example.authservice.repositories.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoleService extends GenericService<Role, RoleDTO>{

    RoleService(RoleRepository roleRepository, RoleMapper roleMapper){
        super(roleRepository, roleMapper);
    }

    public RoleDTO update(RoleDTO roleDTO){
        log.debug("Update Role {}", roleDTO.toString());
        Role role = getGenericMapper().toEntity(roleDTO);
        Optional<Role> byId = getJpaRepository().findById(role.getId());
        if (byId.isEmpty()) {
            throw new CustomException("Role with id " + role.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        Role save = getJpaRepository().save(role);
        log.debug("Updated role with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }

}