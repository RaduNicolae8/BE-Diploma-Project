package com.diploma.project.service;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.CategoryMapper;
import com.diploma.project.model.Category;
import com.diploma.project.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CategoryService extends GenericService<Category, CategoryDTO>{

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        super(categoryRepository, categoryMapper);
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        log.debug("Update function {}", categoryDTO.toString());
        Category category = getGenericMapper().toEntity(categoryDTO);
        Optional<Category> byId = getJpaRepository().findById(category.getId());
        if (byId.isEmpty()) {
            throw new CustomException("Category with id " + category.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        Category save = getJpaRepository().save(category);
        log.debug("Updated function with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }
}
