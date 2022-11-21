package com.its.project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {
    private Long id;
    private ProductDTO product;
    private MemberDTO member;
    private int cartCount;
}
