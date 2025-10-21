package com.example.my_first_spring_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloHtmlController {

    @GetMapping("/hi")
    public String sayHi(Model model) {
        
        model.addAttribute("username", "Gemini"); 
        
        return "hello"; 
    }
}