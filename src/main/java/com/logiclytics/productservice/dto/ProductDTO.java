package com.logiclytics.productservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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