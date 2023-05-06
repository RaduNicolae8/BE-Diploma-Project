package com.diploma.project.mapper;

import com.diploma.project.dto.ServiceTypeDTO;
import com.diploma.project.model.ServiceType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ServiceTypeMapper extends GenericMapper<ServiceType, ServiceTypeDTO>{
}
