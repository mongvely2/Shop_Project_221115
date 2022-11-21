package com.its.project.service;

import com.its.project.dto.MemberDTO;
import com.its.project.dto.MemberFileDTO;
import com.its.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void save(MemberDTO memberDTO, MemberFileDTO memberFileDTO) throws IOException {
        if (!memberFileDTO.getMemberFile().isEmpty()) {
            MultipartFile memberFile = memberFileDTO.getMemberFile();
            String originalFileName = memberFile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "-" + originalFileName;
            memberFileDTO.setOriginalFileName(originalFileName);
            memberFileDTO.setStoredFileName(storedFileName);
            String savePath = "D:\\Shop_memberFile\\" + storedFileName;
            memberFile.transferTo(new File(savePath));
            memberDTO.setFileAttached("Y");
//          MemberDTO saveResult =     exception 발생시 아래 좌변에 추가해볼것
            MemberDTO saveResult = memberRepository.save(memberDTO);
            memberFileDTO.setMemberId(memberDTO.getId());
            memberRepository.saveFileName(memberFileDTO);

        } else {
            memberDTO.setFileAttached("N");
            memberRepository.save(memberDTO);
        }
    }

    public String duplicateCheck(String inputId) {
        String resultEmail = memberRepository.duplicateCheck(inputId);
        if (resultEmail == null) {
            return "Y";
        } else {
            return "N";
        }
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO result = memberRepository.login(memberDTO);
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }
}



























