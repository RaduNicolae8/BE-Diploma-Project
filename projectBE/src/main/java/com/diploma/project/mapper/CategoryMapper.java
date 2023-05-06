package com.diploma.project.mapper;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.model.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO>{
}
