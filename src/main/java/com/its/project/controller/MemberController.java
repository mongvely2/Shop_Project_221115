package com.its.project.controller;

import com.its.project.dto.MemberDTO;
import com.its.project.dto.MemberFileDTO;
import com.its.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String save() {
        return "memberPages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO, MemberFileDTO memberFileDTO) throws IOException {
            memberService.save(memberDTO, memberFileDTO);
            return "memberPages/login";
//        return null;
//        try {
//            return "index";
//        } catch (Exception a) {
//            return "memberPages/save";
//        }
    }

    @PostMapping("/duplicateCheck")
    public @ResponseBody String duplicateCheck(@RequestParam("inputId") String inputId) {
        String resultId = memberService.duplicateCheck(inputId);
        return resultId;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "memberPages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            session.setAttribute("loginId", memberDTO.getMemberId());
            model.addAttribute("modelId", memberDTO.getMemberId());
            return "index";
        } else {
            return "memberPages/login";
        }
    }



}























