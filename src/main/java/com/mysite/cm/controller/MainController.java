package com.mysite.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/CarrotMarket")
    @ResponseBody
    public String index() {
        return "index";
    }
}