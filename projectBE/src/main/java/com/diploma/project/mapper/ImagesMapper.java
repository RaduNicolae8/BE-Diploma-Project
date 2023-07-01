package com.diploma.project.mapper;

import com.diploma.project.dto.ImagesDTO;
import com.diploma.project.model.Images;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ImagesMapper extends GenericMapper<Images, ImagesDTO> {

}
