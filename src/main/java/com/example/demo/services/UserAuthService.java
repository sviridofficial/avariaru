package com.example.demo.services;

import com.example.demo.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      return userDAO.findByLoginUser(username).map(user -> new User(
                user.getLoginUser(),
                user.getPassUser(),
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        )).orElseThrow(()->
              new UsernameNotFoundException("Пользователь не найден!"));

    }
}
