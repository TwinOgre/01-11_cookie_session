package com.example._11.domain.member;

import com.example._11.domain.base.request.Request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final Request request;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Member member = this.memberService.getMember(username);
        if(!member.getPassword().equals(password)){
            return "member/login";
        }
        if(username.equals("admin")){
            request.setSession("admin",member.getId() + "");
        }
        request.setSession("loginedMemberId",member.getId() + "");

        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(){
        request.removeSession("loginedMemberId");

        return "redirect:/";
    }
}
