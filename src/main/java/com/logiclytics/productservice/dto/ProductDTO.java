package com.logiclytics.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoryDTO category;
    private int inventoryStock;
    private String createdDate;
    private String updatedDate;
}