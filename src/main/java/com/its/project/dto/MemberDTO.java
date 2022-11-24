package com.its.project.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private Long id;
    private String userId;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private int memberRole;
    private Timestamp createDate;
    private int login_count;
    private String fileAttached;
    private String delYn;
    private String memberStatus;
}
