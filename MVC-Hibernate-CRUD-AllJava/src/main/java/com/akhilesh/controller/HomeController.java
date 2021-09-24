package com.akhilesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomepage(){
        return "homepage";
    }

    @RequestMapping("/login-page")
    public String showLoginPage(){
        return "login-page";
    }
}
