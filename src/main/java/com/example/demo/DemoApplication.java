package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

@Bean
public BCryptPasswordEncoder passwordEncoder(){
	return new BCryptPasswordEncoder();
}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}