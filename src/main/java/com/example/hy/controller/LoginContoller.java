package com.example.hy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginContoller {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

