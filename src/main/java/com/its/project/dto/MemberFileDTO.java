package com.its.project.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberFileDTO {
    private Long id;
    private MultipartFile memberFile;
    private String originalFileName;
    private String storedFileName;
    private Long member_id;
}
