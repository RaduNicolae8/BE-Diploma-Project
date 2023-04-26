package com.diploma.project.controller;

import com.diploma.project.dto.ServiceTypeDTO;
import com.diploma.project.model.ServiceType;
import com.diploma.project.service.ServiceTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/service-type")
public class ServiceTypeController extends GenericController<ServiceType, ServiceTypeDTO>{
    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        super(serviceTypeService);
    }

    @PutMapping
    public ResponseEntity<ServiceTypeDTO> update(@RequestBody ServiceTypeDTO serviceTypeDTO){
        ServiceTypeDTO updatedServiceType = ((ServiceTypeService) getGenericService()).update(serviceTypeDTO);
        return ResponseEntity.ok(updatedServiceType);
    }
}
