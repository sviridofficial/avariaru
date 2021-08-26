package com.example.demo.controllers;

import com.example.demo.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping(value = "/signin")
    public String signInWebSite(@RequestParam String in_login, @RequestParam String in_password) {

        return "navbar";
    }
}
