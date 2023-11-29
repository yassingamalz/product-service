package com.logiclytics.productservice.service;

import com.logiclytics.productservice.dto.CategoryDTO;
import com.logiclytics.productservice.dto.ProductDTO;
import com.logiclytics.productservice.exception.ProductNotFoundException;
import com.logiclytics.productservice.model.Category;
import com.logiclytics.productservice.model.Product;
import com.logiclytics.productservice.repository.ProductRepository;
import com.logiclytics.productservice.util.Mappers;
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
    CategoryServiceInterface categoryService;

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
        product.setCategory(modelMapper.map(getOrCreateCategory(productDTO.getCategory()), Category.class));
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    private CategoryDTO getOrCreateCategory(CategoryDTO category) {
        return categoryService.getOrCreateCategory(category);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO newProductDTO) {
        // Check if the product exists
        ProductDTO oldProduct = getProductById(id);
        newProductDTO.setCategory(modelMapper.map(getOrCreateCategory(newProductDTO.getCategory()), CategoryDTO.class));

        // Update fields and save
        Mappers.createNotNullModelMapper()
                .map(newProductDTO, oldProduct);

        Product updatedProduct = modelMapper.map(oldProduct, Product.class);
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
