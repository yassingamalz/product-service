package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO getOrCreateCategory(CategoryDTO category) {
        return getCategoryByName(category.getName()).
                map(this::mapToCategoryDTO).orElseGet(() -> createNewCategory(category));
    }

    private CategoryDTO mapToCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    private CategoryDTO createNewCategory(CategoryDTO categoryDTO) {
        Category newCategory = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(newCategory);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

}
