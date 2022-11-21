package com.its.project.controller;

import com.its.project.dto.ProductDTO;
import com.its.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
