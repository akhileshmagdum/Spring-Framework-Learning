package com.akhilesh.SpringbootJSP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomepage() {
        return "homepage";
    }

    @RequestMapping("/jstl-demo")
    public String practiceJstl() {
        return "jstl-demo";
    }
}
