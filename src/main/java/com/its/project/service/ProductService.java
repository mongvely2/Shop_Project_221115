package com.its.project.service;

import com.its.project.dto.ProductDTO;
import com.its.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> productList() {
        return productRepository.productList();
    }
}
