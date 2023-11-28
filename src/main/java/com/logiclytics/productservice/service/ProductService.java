package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.ProductDTO;
import com.logiclytics.productservice.exception.ProductNotFoundException;
import com.logiclytics.productservice.model.Product;
import com.logiclytics.productservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        // Set any additional fields or perform business logic before saving
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        // Check if the product exists
        getProductById(id);

        // Update fields and save
        Product updatedProduct = modelMapper.map(productDTO, Product.class);
        updatedProduct.setId(id);
        Product savedProduct = productRepository.save(updatedProduct);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        // Check if the product exists
        getProductById(id);

        productRepository.deleteById(id);
    }
}
