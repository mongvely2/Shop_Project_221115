package com.its.project.service;

import com.its.project.dto.CategoryDTO;
import com.its.project.dto.MemberDTO;
import com.its.project.dto.ProductDTO;
import com.its.project.dto.ProductFileDTO;
import com.its.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> productList() {
        return productRepository.productList();
    }

    public List<CategoryDTO> categoryList() {
        return productRepository.categoryList();
    }

//    세이브 & 업데이트 로직
    public void save(ProductDTO productDTO,
                     ProductFileDTO productFileDTO,
                     Long saveMemberId,
                     Long saveCategoryId,
//                     CategoryDTO categoryDTO,
                     MultipartFile profile,
                     MultipartFile file) throws IOException {

//        productDTO.setCategory(categoryDTO);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(saveCategoryId);
        productDTO.setCategory(categoryDTO);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(saveMemberId);
        productDTO.setMember(memberDTO);




//        세이브
        if (productDTO.getId() == null || productDTO.getId().equals("")) {
//            MultipartFile productProfile = productFileDTO.getProductProfile(); //1
//            String originalProfileName = productProfile.getOriginalFilename(); //2
//            String storedProfileName = System.currentTimeMillis() + "-" + originalProfileName; //3
//            productFileDTO.setOriginalFileName(originalProfileName); //4
//            productFileDTO.setStoredFileName(storedProfileName); //4
//            String saveProfilePath = "D:\\Shop_productProfile\\" + storedProfileName; //5
//            productProfile.transferTo(new File(saveProfilePath)); //6

            String originalProfileName = profile.getOriginalFilename(); //2
            String storedProfileName = System.currentTimeMillis() + "-" + originalProfileName; //3
            productFileDTO.setOriginalFileName(originalProfileName); //4
            productFileDTO.setStoredFileName(storedProfileName); //4
            String saveProfilePath = "D:\\Shop_productProfile\\" + storedProfileName; //5
            profile.transferTo(new File(saveProfilePath)); //6
            productDTO.setProductProfileAttached("Y");

            String originalFileName = file.getOriginalFilename(); //2
            String storedFileName = System.currentTimeMillis() + "-" + originalFileName; //3
            productFileDTO.setOriginalFileName(originalFileName); //4
            productFileDTO.setStoredFileName(storedFileName); //4
            String saveFilePath = "D:\\Shop_productFile\\" + storedFileName; //5
            file.transferTo(new File(saveFilePath)); //6
            productDTO.setProductFileAttached("Y");

            productRepository.saveFile(productFileDTO);
            ProductDTO result = productRepository.save(productDTO);

//            MultipartFile productFile = productFileDTO.getProductFile(); //1
//            String originalFileName = productFile.getOriginalFilename(); //2
//            String storedFileName = System.currentTimeMillis() + "-" + originalFileName; //3
//            productFileDTO.setOriginalFileName(originalFileName); //4
//            productFileDTO.setStoredFileName(storedFileName); //4
//            String saveFilePath = "D:\\Shop_productFile\\" + storedFileName; //5
//            productFile.transferTo(new File(saveFilePath)); //6
//            productRepository.save(productDTO);

//            업데이트
        }
//        else {
//            productRepository.update(productDTO);
//        }
    }

//    public MemberDTO saveMemberId(MemberDTO loginId) {
//        return productRepository.saveMemberId(loginId);
//    }
}
