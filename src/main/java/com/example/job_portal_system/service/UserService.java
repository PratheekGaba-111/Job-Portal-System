package com.example.job_portal_system.service;

import com.example.job_portal_system.model.User;

public interface UserService {
    String register(User user, String role);
}
