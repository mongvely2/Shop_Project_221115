package com.its.project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {
    private Long id;
    private ProductDTO cartProduct;
    private MemberDTO cartMember;
    private int cartCount;
}
