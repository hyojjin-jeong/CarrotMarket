package com.mysite.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.mysite.cm.dto.MemberJoinDto;
import com.mysite.cm.service.MemberService;

@Controller
@RequestMapping("/CarrotMarket")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/login")
    public String index() {
        return "login";
	}

	@GetMapping("/join")
    public String joinPage(Model model){
        model.addAttribute("form", new MemberJoinDto());
        return "members/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberJoinDto form){
        memberService.join(form.toMemberEntity());
        return "redirect:/";
    }
}