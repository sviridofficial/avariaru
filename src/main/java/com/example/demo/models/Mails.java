package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter


@Entity(name ="Mails" )
public class Mails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mail", unique = true)
    private String mailAddress;

    public Mails(String mailAddress) {
        this.mailAddress = mailAddress;
    }


    public Mails() {

    }
}
