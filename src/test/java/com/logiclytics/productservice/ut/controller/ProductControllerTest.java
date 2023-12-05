package com.logiclytics.productservice.ut.controller;

import com.logiclytics.productservice.controller.ProductController;
import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.dto.ProductDTO;
import com.logiclytics.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() {
        // Arrange
        Long productId = 1L;
        ProductDTO mockProduct = ProductDTO.builder()
                .id(productId)
                .name("Test Product")
                .price(10.99)
                .category(CategoryDTO.builder().build())
                .inventoryStock(100)
                .createdDate("2023-01-01")
                .updatedDate("2023-01-02")
                .build();

        when(productService.getProductById(eq(productId))).thenReturn(mockProduct);

        // Act
        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    void testGetAllProducts() {
        // Arrange
        List<ProductDTO> mockProducts = Collections.singletonList(
                ProductDTO.builder()
                        .id(1L)
                        .name("Test Product 1")
                        .price(10.99)
                        .category(CategoryDTO.builder().build())
                        .inventoryStock(100)
                        .createdDate("2023-01-01")
                        .updatedDate("2023-01-02")
                        .build()
        );

        when(productService.getAllProducts()).thenReturn(mockProducts);

        // Act
        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProducts, response.getBody());
    }

    @Test
    void testCreateProduct() {
        // Arrange
        ProductDTO requestProduct = ProductDTO.builder()
                .name("New Product")
                .price(19.99)
                .category(CategoryDTO.builder().build())
                .inventoryStock(0)
                .build();

        ProductDTO createdProduct = ProductDTO.builder()
                .id(1L)
                .name("New Product")
                .price(19.99)
                .category(CategoryDTO.builder().build())
                .inventoryStock(0)  // Assuming default inventory stock
                .createdDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE))  // Assuming created date
                .updatedDate(null)  // Assuming initially null
                .build();

        when(productService.createProduct(eq(requestProduct))).thenReturn(createdProduct);

        // Act
        ResponseEntity<ProductDTO> response = productController.createProduct(requestProduct);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createdProduct, response.getBody());
    }

}
