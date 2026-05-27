package com.example.attendanceapp.controller;

import com.example.attendanceapp.dto.AuthResponse;
import com.example.attendanceapp.dto.LoginRequest;

import com.example.attendanceapp.entity.User;

import com.example.attendanceapp.jwt.JwtService;

import com.example.attendanceapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")

public class AuthController {

    @Autowired

    UserRepository userRepository;

    @Autowired

    JwtService jwtService;


    @PostMapping("/register")
    public User register(
            @RequestBody User user){

        System.out.println(user.getName());

        return userRepository.save(user);
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getRole().name(),
                user.getId()
        );
    }

}