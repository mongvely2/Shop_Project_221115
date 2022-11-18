package com.its.project.repository;

import com.its.project.dto.MemberDTO;
import com.its.project.dto.MemberFileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public MemberDTO save(MemberDTO memberDTO) {
        sql.insert("Member.save", memberDTO);
        return memberDTO;
    }

    public void saveFileName(MemberFileDTO memberFileDTO) {
        sql.insert("Member.saveFileName", memberFileDTO);
    }

    public String duplicateCheck(String inputId) {
        return sql.selectOne("Member.duplicateCheck", inputId);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }
}











































