package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.exception.CategoryNotFoundException;
import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.repository.CategoryRepository;
import com.logiclytics.productservice.util.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO getOrCreateCategory(CategoryDTO category) {
        return findCategoryByName(category.getName()).
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
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        return modelMapper.map(category, CategoryDTO.class);
    }



    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: " + categoryName));
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO newcategoryDTO) {
        CategoryDTO oldCategory = getCategoryById(id);
        // Update fields and save
        Mappers.createNotNullModelMapper()
                .map(newcategoryDTO, oldCategory);

        Category updatedCategory = modelMapper.map(oldCategory, Category.class);
        Category savedProduct = categoryRepository.save(updatedCategory);

        return modelMapper.map(savedProduct, CategoryDTO.class);

    }

    @Override
    public void deleteCategory(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }

    public Optional<Category> findCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

}
