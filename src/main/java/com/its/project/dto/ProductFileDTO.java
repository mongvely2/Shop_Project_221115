package com.its.project.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductFileDTO {
    private Long id;
//    private MultipartFile productProfile;
//    private MultipartFile productFile;
    private String originalFileName;
    private String storedFileName;
    private ProductDTO product;
}
