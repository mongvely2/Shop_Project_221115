package com.its.project.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private Long id;
    private String productName;
    private String productContents;
    private String productPrice;
    private String productStock;
    private String productDelete;
    private String productSale;
    private Timestamp productCreate;
    private String productAttached;
    private CategoryDTO category;

}
