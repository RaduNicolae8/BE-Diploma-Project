package com.diploma.project.mapper;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T12:49:31+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( DTO.getId() );
        category.setName( DTO.getName() );
        category.setDescription( DTO.getDescription() );

        return category;
    }

    @Override
    public CategoryDTO toDTO(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( entity.getId() );
        categoryDTO.setName( entity.getName() );
        categoryDTO.setDescription( entity.getDescription() );

        return categoryDTO;
    }

    @Override
    public List<Category> toEntity(List<CategoryDTO> DTOs) {
        if ( DTOs == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( DTOs.size() );
        for ( CategoryDTO categoryDTO : DTOs ) {
            list.add( toEntity( categoryDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toDTO(List<Category> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entities.size() );
        for ( Category category : entities ) {
            list.add( toDTO( category ) );
        }

        return list;
    }
}
