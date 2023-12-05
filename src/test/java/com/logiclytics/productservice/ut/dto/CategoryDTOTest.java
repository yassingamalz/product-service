package com.logiclytics.productservice.ut.dto;

import com.logiclytics.productservice.dto.CategoryDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryDTOTest {

    @Test
    void testCategoryDTOBuilder() {
        // Arrange
        Long categoryId = 1L;
        String categoryName = "Test Category";
        String categoryDescription = "Category description";

        // Act
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(categoryId)
                .name(categoryName)
                .description(categoryDescription)
                .build();

        // Assert
        assertEquals(categoryId, categoryDTO.getId());
        assertEquals(categoryName, categoryDTO.getName());
        assertEquals(categoryDescription, categoryDTO.getDescription());
    }
}
