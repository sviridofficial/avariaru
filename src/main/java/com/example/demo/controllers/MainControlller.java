package com.example.demo.controllers;


import com.example.demo.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainControlller {
    @Autowired
    private NotificationService notificationService;

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


    @RequestMapping(value = "/mailsender", method = RequestMethod.POST)
    public String sendMail(@RequestParam String mail, @RequestParam String comment) {
        notificationService.sendNotification(mail,comment);
        return "redirect:/partnership";
    }

}
