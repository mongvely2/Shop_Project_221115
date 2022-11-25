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
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            if (profile == null || file == null) {
                ProductDTO result = productRepository.save(productDTO);
            }
//            productDTO.setProductProfileAttached("N");
//            productDTO.setProductFileAttached("N");
            if (profile != null) {
                String originalProfileName = profile.getOriginalFilename(); //2
                String storedProfileName = System.currentTimeMillis() + "-" + originalProfileName; //3
                productFileDTO.setOriginalFileName(originalProfileName); //4
                productFileDTO.setStoredFileName(storedProfileName); //4
                String saveProfilePath = "D:\\Shop_productProfile\\" + storedProfileName; //5
                profile.transferTo(new File(saveProfilePath)); //6
//                productFileDTO.setProduct(productDTO.getId());
//                Long productId = productFileDTO.getProduct().getId();
//                productFileDTO.setProduct(productId);
                productDTO.setProductProfileAttached("Y");
                ProductDTO result = productRepository.save(productDTO);
                productFileDTO.setProduct(productDTO);
                productFileDTO.setFileType("T");
                productRepository.saveFile(productFileDTO);
            }
            if (file != null) {
                String originalFileName = file.getOriginalFilename(); //2
                String storedFileName = System.currentTimeMillis() + "-" + originalFileName; //3
                productFileDTO.setOriginalFileName(originalFileName); //4
                productFileDTO.setStoredFileName(storedFileName); //4
                String saveFilePath = "D:\\Shop_productFile\\" + storedFileName; //5
                file.transferTo(new File(saveFilePath)); //6
                productDTO.setProductFileAttached("Y");
                ProductDTO result = productRepository.save(productDTO);
                productFileDTO.setProduct(productDTO);
                productFileDTO.setFileType("D");
                productRepository.saveFile(productFileDTO);
            }
        }
//        업데이트
//        else {
//            productRepository.update(productDTO);
//        }
    }

//    public ProductDTO findById(Long id) {
//        return productRepository.findById(id);
//    }

    public void updateHits(Long id) {
        productRepository.updateHits(id);
    }

    public Map findById(Long id) {
        System.out.println("service id = " + id);
        ProductDTO productDTO = productRepository.findById(id);
        System.out.println("productDTO = " + productDTO);
        Map findById = new LinkedHashMap();
        findById.put("findProduct", productDTO);
        if (productDTO.getProductProfileAttached().equals("Y")) {
//            fileType=="T"
            ProductFileDTO productFileDTO = productRepository.findProductProfile(id);
            findById.put("findProfile", productFileDTO);
        }
        if (productDTO.getProductFileAttached().equals("Y")) {
//            fileType=="D"
            ProductFileDTO productFileDTO = productRepository.findProductFile(id);
            findById.put("findFile", productFileDTO);
        }
        return findById;

    }


//    public MemberDTO saveMemberId(MemberDTO loginId) {
//        return productRepository.saveMemberId(loginId);
//    }
}
