package com.spring.security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/admin")
    public ResponseEntity<String> admLogin() {
        return new ResponseEntity<>("Admin Login", HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<String> userLogin() {
        return new ResponseEntity<>("User Login", HttpStatus.OK);
    }
}
