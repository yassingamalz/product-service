package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.model.Category;

import java.util.Optional;

public interface CategoryServiceInterface {

    Optional<Category> getCategoryByName(String categoryName);

    CategoryDTO getOrCreateCategory(CategoryDTO category);

}
