package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlller {
    @GetMapping("/mainpage")
    public String home() {
        return "navbar";
    }

    @GetMapping("/about")
    public String aboutme() {
        return "aboutme";
    }

    @GetMapping("/partnership")
    public String partnership() {
        return "partner";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
}
