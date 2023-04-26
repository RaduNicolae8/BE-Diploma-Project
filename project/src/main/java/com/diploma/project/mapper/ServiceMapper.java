package com.diploma.project.mapper;

import com.diploma.project.dto.ServiceDTO;
import com.diploma.project.model.Service;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ServiceMapper extends GenericMapper<Service, ServiceDTO>{
}
