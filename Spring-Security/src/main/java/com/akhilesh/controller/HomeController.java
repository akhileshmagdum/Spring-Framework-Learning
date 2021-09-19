package com.akhilesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomepage(){
        return "homepage";
    }

    @RequestMapping("/showlogin")
    public String showLoginForm(){
        return "login-form";
    }
}
