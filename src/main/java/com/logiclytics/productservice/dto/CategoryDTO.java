package com.logiclytics.productservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
}
