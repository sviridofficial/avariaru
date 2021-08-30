package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", unique = true)
    private String loginUser;

    @Column(name = "pass", unique = true)
    private String passUser;

    @Column(name="user_mail", unique = true)
    private String userMail;

    public Users(String loginUser, String passUser) {
        this.loginUser = loginUser;
        this.passUser = passUser;
    }
    public Users(){

    }
}
