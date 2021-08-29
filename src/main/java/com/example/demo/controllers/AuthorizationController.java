package com.example.demo.controllers;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthorizationController {


    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        String errorMessage = "Пользователь с такой электронной почтой или паролем не найден";
        model.addAttribute("errorMessage", errorMessage);
        return "signin";
    }
}



