package com.diploma.project.controller;

import com.diploma.project.dto.RoleDTO;
import com.diploma.project.model.Role;
import com.diploma.project.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
public class RoleController extends GenericController<Role, RoleDTO> {
    public RoleController(RoleService roleService) {
        super(roleService);
    }

    @PutMapping
    public ResponseEntity<RoleDTO> update(@RequestBody RoleDTO roleDTO) {
        RoleDTO updatedRole = ((RoleService) getGenericService()).update(roleDTO);
        return ResponseEntity.ok(updatedRole);
    }
}
