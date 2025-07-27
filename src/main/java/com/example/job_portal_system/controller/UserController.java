package com.example.job_portal_system.controller;

import com.example.job_portal_system.model.User;
import com.example.job_portal_system.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Register as USER (Job Seeker)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user, "ROLE_USER"));
    }

    // ✅ Register as EMPLOYER
    @PostMapping("/register/employer")
    public ResponseEntity<String> registerEmployer(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user, "ROLE_EMPLOYER"));
    }

    // ✅ Protected route for ROLE_USER
    @GetMapping("/secure")
    public ResponseEntity<String> secureEndpoint() {
        return ResponseEntity.ok("Access granted: You are authenticated!");
    }

    // ✅ Login endpoint
    @GetMapping("/login")
    public ResponseEntity<String> login(Authentication authentication) {
        return ResponseEntity.ok("Login successful! Welcome, " + authentication.name());
    }
}
