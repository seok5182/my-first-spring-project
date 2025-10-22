package com.example.my_first_spring_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHtmlController {

    @GetMapping("/hi")
    public String sayHi(Model model) {
        
        model.addAttribute("username", "Gemini"); 
        
        return "hello"; 
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit-name")
    public String handleSubmit(
            @RequestParam("username") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        
        return "result";
    }
}