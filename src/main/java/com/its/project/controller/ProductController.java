package com.its.project.controller;

import com.its.project.dto.CategoryDTO;
import com.its.project.dto.MemberDTO;
import com.its.project.dto.ProductDTO;
import com.its.project.dto.ProductFileDTO;
import com.its.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public String productList(Model model) {

        List<ProductDTO> productList = productService.productList();
        model.addAttribute("productList", productList);

        return "productPages/productList";
    }

    @GetMapping("/productSaveForm")
    public String saveForm(Model model, HttpSession session ) {
//        MemberDTO loginId = (MemberDTO) session.getAttribute("loginDate");
//        MemberDTO memberDTO = productService.saveMemberId(loginId);
//        model.addAttribute("memberDTO", memberDTO);
//        model.addAttribute("memberDTO", loginId);
        List<CategoryDTO> categoryList = productService.categoryList();
        model.addAttribute("categoryList", categoryList);
//        System.out.println("categoryList = " + categoryList.get(1));
//        System.out.println("categoryList = " + categoryList.get(2));
        return "productPages/productSave";
    }

    @PostMapping("/productSave")
    public String save(@ModelAttribute ProductDTO productDTO,
                       @ModelAttribute ProductFileDTO productFileDTO,
//                       @ModelAttribute CategoryDTO categoryDTO,
                       @RequestParam Long saveMemberId,
                       @RequestParam Long saveCategoryId,
                       @RequestParam MultipartFile profile,
                       @RequestParam MultipartFile file) throws IOException {
        System.out.println("컨트롤러 saveMemberId = " + saveMemberId);
        productService.save(productDTO,productFileDTO, saveMemberId, saveCategoryId, profile, file);
//        productService.save(productDTO,productFileDTO,categoryDTO, profile, file);
        return "index";
//        return "redirect:/product/productList";
    }

//    @GetMapping("/findByid")
//    public String findById() {
//
//    }




}
