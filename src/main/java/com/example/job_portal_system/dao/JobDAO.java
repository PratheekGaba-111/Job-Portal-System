package com.example.job_portal_system.dao;

import com.example.job_portal_system.model.Job;
import com.example.job_portal_system.model.User;

import java.util.List;
import java.util.Optional;

public interface JobDAO {
    void save(Job job);
    List<Job> findAll();
    Optional<Job> findById(Long id);
    List<Job> findByPostedBy(User user);
    void deleteById(Long id);
}
