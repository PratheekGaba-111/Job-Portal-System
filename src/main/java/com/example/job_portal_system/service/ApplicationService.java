package com.example.job_portal_system.service;

import com.example.job_portal_system.model.Application;

import java.util.List;

public interface ApplicationService {
    Application applyToJob(Long jobId, String applicantUsername);
    List<Application> getApplicationsByApplicant(String username);
    List<Application> getApplicationsForJob(Long jobId);
    List<Application> getAllApplications();
    void updateApplicationStatus(Long applicationId, String status);
}
