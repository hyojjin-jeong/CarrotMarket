package com.mysite.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@GetMapping("/CarrotMarket")
    public String index() {
        return "main";
	}
    
    
}