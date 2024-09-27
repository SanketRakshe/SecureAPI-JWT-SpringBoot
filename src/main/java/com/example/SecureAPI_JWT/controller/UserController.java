package com.example.SecureAPI_JWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecureAPI_JWT.model.Users;
import com.example.SecureAPI_JWT.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody Users user) {

    	return service.verify(user);
    }
}