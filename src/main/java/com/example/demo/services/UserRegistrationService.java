package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void create(String login, String password, String mail){
        Users user = new Users();
        user.setLoginUser(login);
        user.setPassUser(bCryptPasswordEncoder.encode(password));
        user.setUserMail(mail);
        userDAO.save(user);
    }
}
