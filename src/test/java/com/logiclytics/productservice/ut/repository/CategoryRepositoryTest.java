package com.logiclytics.productservice.ut.repository;

import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSaveCategory() {
        // Arrange
        Category category = new Category(null,"Test Category","Category description");

        // Act
        Category savedCategory = categoryRepository.save(category);

        // Assert
        assertNotNull(savedCategory.getId());
        assertEquals("Test Category", savedCategory.getName());
        assertEquals("Category description", savedCategory.getDescription());
    }

    @Test
    void testFindById() {
        // Arrange
        Category category = new Category(null,"Test Category","Category description");
        Category savedCategory = categoryRepository.save(category);

        // Act
        Optional<Category> foundCategory = categoryRepository.findById(savedCategory.getId());

        // Assert
        assertTrue(foundCategory.isPresent());
        assertEquals(savedCategory.getId(), foundCategory.get().getId());
        assertEquals("Test Category", foundCategory.get().getName());
        assertEquals("Category description", foundCategory.get().getDescription());
    }

    @Test
    void testFindAll() {
        // Arrange
        Category category1 = new Category(null,"Test Category 1","Category description 1");
        categoryRepository.save(category1);

        Category category2 = new Category(null,"Test Category 2","Category description 2");
        categoryRepository.save(category2);

        // Act
        List<Category> categories = categoryRepository.findAll();

        // Assert
        assertFalse(categories.isEmpty());
        assertEquals(7, categories.size());
    }

}
