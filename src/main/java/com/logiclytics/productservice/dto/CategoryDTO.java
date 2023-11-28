package com.logiclytics.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
}
