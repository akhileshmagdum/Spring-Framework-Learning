package com.akhilesh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage(){
        return "homepage";
    }

    @RequestMapping("/showform")
    public String showForm(){
        return "showform";
    }

    @RequestMapping("/processform")
    public String processForm(){
        return "processform";
    }

    public List<String> courses;

    @PostConstruct
    public void loadData(){
        courses = Arrays.asList("Java","Python","C++","Ruby");
    }

    @RequestMapping("/enrollcourse")
    public String enrollCourse(Model model){
        Random random = new Random();
        String alCourse = courses.get(random.nextInt(courses.size()));
        model.addAttribute("course",alCourse);
        return "enrollcourse";
    }
}
