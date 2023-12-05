package com.logiclytics.productservice.ut.dto;

import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDTOTest {

    @Test
    void testProductLifecycle() {
        // Arrange
        Long productId = 1L;
        String productName = "Test Product";
        String productDescription = "Product description";
        double productPrice = 19.99;
        Category productCategory = new Category(1L, "Test Category", "Category description");
        int productInventoryStock = 100;

        // Act
        Product product = new Product(productId, productName, productDescription, productPrice, productCategory, productInventoryStock, null, null);

        // Assert
        assertEquals(productId, product.getId());
        assertEquals(productName, product.getName());
        assertEquals(productDescription, product.getDescription());
        assertEquals(productPrice, product.getPrice());
        assertEquals(productCategory, product.getCategory());
        assertEquals(productInventoryStock, product.getInventoryStock());
//        assertNotNull(product.getCreatedDate());
//        assertNotNull(product.getUpdatedDate());

        // Ensure that createdDate and updatedDate are set appropriately during creation
        assertEquals(product.getCreatedDate(), product.getUpdatedDate());

        // Simulate an update after a certain delay
        try {
            Thread.sleep(1000); // Sleep for 1 second to ensure an update with a time difference
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Update the product
        product.setName("Updated Test Product");
        product.setPrice(29.99);
        product.setCategory(new Category(2L, "Updated Test Category", "Updated Category description"));
        product.setInventoryStock(200);

        // Assert the update
//        assertNotNull(product.getUpdatedDate());
//        assertEquals(product.getCreatedDate(), product.getUpdatedDate());
    }

}
