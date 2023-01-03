
package com.example.demo;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*; 

@Controller
public class HelloController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}

