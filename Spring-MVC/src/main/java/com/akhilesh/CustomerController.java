package com.akhilesh;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    /*
The Init Binder is an annotation that is used to customize the request being sent to the controller.
It helps to control and format requests that come to the controller as it is defined in the controller.
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/showformC")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer()); //Here we add the customer to the model(data)
        return "customerform";
    }

    @RequestMapping("/processform")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customerform";
        }
        else {
            return "customerprocess";
        }
    }
}
