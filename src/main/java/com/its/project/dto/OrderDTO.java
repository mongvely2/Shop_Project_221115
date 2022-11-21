package com.its.project.dto;


import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private Long id;
    private String orderNum;
    private String orderResponse;
    private String orderAddress;
    private String orderPrice;
    private Timestamp orderDate;
    private String orderStatus;
    private MemberDTO member;
}
