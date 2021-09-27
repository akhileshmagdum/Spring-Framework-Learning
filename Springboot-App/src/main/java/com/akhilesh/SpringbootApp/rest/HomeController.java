package com.akhilesh.SpringbootApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String helloSpringboot(){
        return "Hello Springboot";
    }


    @GetMapping("/hello")
    public  String testingDevToolsAutoReload(){
        return "this page is automatically updated";
    }
}
