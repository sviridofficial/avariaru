package com.example.demo.repo;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDAO extends JpaRepository<Users, Integer> {
    Optional<Users> findByLoginUser(String loginUser);
}
