package com.example.hy.base.controller;

import com.example.hy.system.entity.HyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class BaseController {

    @Autowired
    public HttpServletRequest request;   //首先可以通过注解的方式  获取一个 request

    public HttpSession session;

    public void setSession(String key, Object obj){
        this.session = (null == this.session) ? this.request.getSession() : this.session;
        this.session.setAttribute(key, obj);
    }

    public HttpSession getSession(){
        return (null == this.session) ? this.request.getSession() : this.session;
    }

    public HttpServletRequest getRequest(){
        return this.request;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public HyUser getCurrentUser(){
        return (HyUser) this.getSession().getAttribute("loginUser");
    }
}
