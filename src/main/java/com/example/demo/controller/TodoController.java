package com.example.demo.controller;

import com.example.demo.config.JwtTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class TodoController {
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody HashMap<String, String> user) {
        JwtTokenUtils jwtToken = new JwtTokenUtils();
        String token = jwtToken.generateToken(user); // 取得token

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
    @GetMapping("/hello")
    public ResponseEntity hello(@RequestHeader("Authorization") String au) {
        String token = au.substring(6);
        JwtTokenUtils jwtToken = new JwtTokenUtils();
        try {
            jwtToken.validateToken(token);
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Hello dunccan");
    }
}