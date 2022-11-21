package com.its.project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDTO {
    private Long id;
    private ProductDTO product;
    private OrderDTO order;
    private int itemCount;
}
