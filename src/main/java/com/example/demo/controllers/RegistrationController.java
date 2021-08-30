package com.example.demo.controllers;

import com.example.demo.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping(value = "/signup")
    public String createNewUser(@RequestParam String r_login, @RequestParam String r_password, @RequestParam String r_mail, Model model) {
        try {
            userRegistrationService.create(r_login, r_password, r_mail);
            model.addAttribute("successRegistration", "Вы успешно создали новый аккаунт");
            return "signin";
        } catch (Exception e) {
            model.addAttribute("failedRegistration","Ошибка регистрации, попробуйте еще раз");
            return "signup";
        }

    }
}
