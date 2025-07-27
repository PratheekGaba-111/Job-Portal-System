package com.example.job_portal_system.service;

import com.example.job_portal_system.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    void createJob(Job job, String username);
    List<Job> getAllJobs();
    Optional<Job> getJobById(Long id);
    List<Job> getJobsByEmployer(String username);
    void deleteJob(Long id);
}
