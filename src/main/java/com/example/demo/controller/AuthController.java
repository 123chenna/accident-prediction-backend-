package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.User_Service;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://127.0.0.1:5500") 
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private User_Service service;

    @Autowired
    private JwtUtil jwtUtil;

//    @PostMapping("/signup")
//    public String signup(@RequestBody User user) {
//        return service.register(user);
//    }
    @PostMapping("/signup")
   
    public ResponseEntity<?> signup(@RequestBody User user) {

        if(user.getUsername() == null || user.getUsername().isEmpty() ||
           user.getPassword() == null || user.getPassword().isEmpty()) {

            return ResponseEntity.badRequest().body("Fields cannot be empty");
        }

        service.register(user); // ✅ FIXED
        return ResponseEntity.ok("User registered successfully");
    }


    
    
//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody User user) {
//
//        User u = service.login(user);
//
//        if (u != null) {
//            String token = jwtUtil.generateToken(user.getUsername());
//            return Map.of("token", token);
//        }
//
//        return Map.of("error", "Invalid");
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        if(user.getUsername() == null || user.getUsername().isEmpty() ||
           user.getPassword() == null || user.getPassword().isEmpty()) {

            return ResponseEntity.badRequest().body("Username & Password required");
        }

        User u = service.login(user);

        if (u != null) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}