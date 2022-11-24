package com.its.project.repository;

import com.its.project.dto.CategoryDTO;
import com.its.project.dto.MemberDTO;
import com.its.project.dto.ProductDTO;
import com.its.project.dto.ProductFileDTO;
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

    public List<CategoryDTO> categoryList() {
        return sql.selectList("Product.categoryList");
    }

    public ProductDTO save(ProductDTO productDTO) {
        sql.insert("Product.save", productDTO);
        return productDTO;
    }

    public void saveFile(ProductFileDTO productFileDTO) {
        sql.insert("Product.saveFile", productFileDTO);
    }

//    public MemberDTO saveMemberId(MemberDTO loginId) {
//        return sql.selectOne("saveMemberId", loginId);
//    }
}
