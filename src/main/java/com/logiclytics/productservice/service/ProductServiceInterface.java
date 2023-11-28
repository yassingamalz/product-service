package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);
}
