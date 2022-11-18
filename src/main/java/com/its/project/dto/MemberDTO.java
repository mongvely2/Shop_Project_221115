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
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private int memberRole;
    private Timestamp create_date;
    private String fileAttached;
    private int login_count;
}
