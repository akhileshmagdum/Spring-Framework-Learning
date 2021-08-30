package com.akhilesh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        return "studentform";
    }

    @RequestMapping("/processform")
    public String processForm(@ModelAttribute("student") Student student){
        return "studentprocess";
    }
}
