package com.its.project.repository;

import com.its.project.dto.ProductDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public List<ProductDTO> productList() {
        return sql.selectList("Product.productList");
    }
}
