package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {
    
    @GetMapping("/great")
    public String great(){
        return "Hello, World! This is a simple Spring Boot application.";
    }
}
