package com.diploma.project.service;

import com.diploma.project.dto.ServiceTypeDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.ServiceTypeMapper;
import com.diploma.project.model.ServiceType;
import com.diploma.project.repository.ServiceTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ServiceTypeService extends GenericService<ServiceType, ServiceTypeDTO> {
    ServiceTypeService(ServiceTypeRepository serviceTypeRepository, ServiceTypeMapper serviceTypeMapper) {
        super(serviceTypeRepository, serviceTypeMapper);
    }

    ServiceTypeDTO update(ServiceTypeDTO serviceTypeDTO){
        log.debug("Update ServiceType {}", serviceTypeDTO.toString());
        ServiceType serviceType = getGenericMapper().toEntity(serviceTypeDTO);
        Optional<ServiceType> byId = getJpaRepository().findById(serviceType.getId());
        if (byId.isEmpty()) {
            throw new CustomException("ServiceType with id " + serviceType.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        ServiceType save = getJpaRepository().save(serviceType);
        log.debug("Updated serviceType with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }
}
