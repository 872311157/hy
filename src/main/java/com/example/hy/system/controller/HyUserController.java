package com.example.hy.system.controller;

import com.example.hy.system.service.IHyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hyUser")
public class HyUserController {
    @Autowired
    private IHyUserService hyUserService;

    /**
     * 获取日志对象，构造函数传入当前类，查找日志方便定位
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String page(){
        return "system/hyuser/demo.html";
    }
}
