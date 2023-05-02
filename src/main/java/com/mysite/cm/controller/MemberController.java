package com.mysite.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CarrotMarket")
public class MemberController {
	@GetMapping("/login")
    public String index() {
        return "login";
	}
}