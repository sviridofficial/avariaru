package com.example.demo.repo;

import com.example.demo.models.Users;
import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<Users, Integer> {

}
