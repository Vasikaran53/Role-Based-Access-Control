package com.example.assignment.controller;


import com.example.assignment.models.User;
import com.example.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

   
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll(); 
    }
}
