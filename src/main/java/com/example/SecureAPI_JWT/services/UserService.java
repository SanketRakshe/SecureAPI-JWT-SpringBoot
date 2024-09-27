package com.example.SecureAPI_JWT.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SecureAPI_JWT.model.Users;
import com.example.SecureAPI_JWT.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
    	user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);

    }
}