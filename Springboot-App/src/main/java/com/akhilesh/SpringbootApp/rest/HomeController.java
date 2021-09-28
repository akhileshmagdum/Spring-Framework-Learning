package com.akhilesh.SpringbootApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${dmi.name}")
    private String name;

    @Value("${dmi.position}")
    private String position;

    @GetMapping("/")
    public String helloSpringboot(){
        return "Hello Springboot";
    }


    @GetMapping("/hello")
    public  String testingDevToolsAutoReload(){
        return "this page is automatically updated";
    }

    @GetMapping("/property-injection")
    public String propertyInjection(){
        return name+" is a "+position;
    }
}
