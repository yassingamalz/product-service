package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceInterface {

    CategoryDTO getCategoryById(Long id);
    
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String categoryName);

    CategoryDTO getOrCreateCategory(CategoryDTO category);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);
}
