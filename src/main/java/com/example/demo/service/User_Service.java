package com.example.demo.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class User_Service {

    @Autowired
    private UserRepository repo;

    public String register(User user) {
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            return "User already exists";
        }
        repo.save(user);
        return "Registered successfully";
    }

    public User login(User user) {
        return repo.findByUsername(user.getUsername())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElse(null);
    }
}
