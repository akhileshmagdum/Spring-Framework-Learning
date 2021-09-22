package com.akhilesh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HomeController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }
}
