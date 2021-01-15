package com.example.hy.system.controller;

import com.example.hy.system.service.IHyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hyuser")
public class HyUserController {
    @Autowired
    private IHyUserService hyUserService;

    @RequestMapping("")
    public String page(){
        return "system/hyuser/demo.html";
    }
}
