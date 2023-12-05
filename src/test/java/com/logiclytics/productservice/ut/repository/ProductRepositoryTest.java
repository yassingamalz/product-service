package com.logiclytics.productservice.ut.repository;

import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.model.Product;
import com.logiclytics.productservice.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        // Initialize or save test data before each test if needed
    }

    @AfterEach
    void tearDown() {
        // Clean up or reset data after each test if needed
    }

    @Test
    void testSaveProduct() {
        // Arrange
        Category category = new Category(null, "Test Category 1", "Category description 1");
        Product product = new Product(null, "Test Product", "Product description", 19.99, category, 100, null, null);


        // Act
        Product savedProduct = productRepository.save(product);

        // Assert
        assertNotNull(savedProduct.getId());
        assertEquals("Test Product", savedProduct.getName());
        assertEquals("Product description", savedProduct.getDescription());
        assertEquals(19.99, savedProduct.getPrice());
        assertEquals(category, savedProduct.getCategory());
        assertEquals(100, savedProduct.getInventoryStock());
        assertNotNull(savedProduct.getCreatedDate());
        assertNotNull(savedProduct.getUpdatedDate());
    }

    @Test
    void testFindById() {
        // Arrange
        Category category = new Category(null, "Test Category 1", "Category description 1");
        Product product = new Product(null, "Test Product", "Product description", 19.99, category, 100, null, null);

        Product savedProduct = productRepository.save(product);

        // Act
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        // Assert
        assertTrue(foundProduct.isPresent());
        assertEquals(savedProduct.getId(), foundProduct.get().getId());
        assertEquals("Test Product", foundProduct.get().getName());
        assertEquals("Product description", foundProduct.get().getDescription());
        assertEquals(19.99, foundProduct.get().getPrice());
        assertEquals(category, foundProduct.get().getCategory());
        assertEquals(100, foundProduct.get().getInventoryStock());
        assertNotNull(foundProduct.get().getCreatedDate());
        assertNotNull(foundProduct.get().getUpdatedDate());
    }
}
