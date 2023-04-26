package com.diploma.project.controller;

import com.diploma.project.dto.CategoryDTO;
import com.diploma.project.model.Category;
import com.diploma.project.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController extends GenericController<Category, CategoryDTO> {
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO updatedCategory = ((CategoryService) getGenericService()).update(categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }
}
