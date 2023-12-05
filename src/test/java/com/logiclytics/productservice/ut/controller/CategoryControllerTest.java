package com.logiclytics.productservice.ut.controller;

import com.logiclytics.productservice.controller.CategoryController;
import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCategoryById() {
        // Arrange
        Long categoryId = 1L;
        CategoryDTO mockCategory = CategoryDTO.builder()
                .id(categoryId)
                .name("Test Category")
                .description("Category description")
                .build();

        when(categoryService.getCategoryById(eq(categoryId))).thenReturn(mockCategory);

        // Act
        ResponseEntity<CategoryDTO> response = categoryController.getCategoryById(categoryId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCategory, response.getBody());
    }

    @Test
    void testGetAllCategories() {
        // Arrange
        List<CategoryDTO> mockCategories = Collections.singletonList(
                CategoryDTO.builder()
                        .id(1L)
                        .name("Test Category 1")
                        .description("Category description 1")
                        .build()
        );

        when(categoryService.getAllCategories()).thenReturn(mockCategories);

        // Act
        ResponseEntity<List<CategoryDTO>> response = categoryController.getAllCategories();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCategories, response.getBody());
    }

    @Test
    void testCreateCategory() {
        // Arrange
        CategoryDTO requestCategory = CategoryDTO.builder()
                .name("New Category")
                .description("New Category description")
                .build();

        CategoryDTO createdCategory = CategoryDTO.builder()
                .id(1L)
                .name("New Category")
                .description("New Category description")
                .build();

        when(categoryService.createCategory(eq(requestCategory))).thenReturn(createdCategory);

        // Act
        ResponseEntity<CategoryDTO> response = categoryController.createCategory(requestCategory);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createdCategory, response.getBody());
    }

}
