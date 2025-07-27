package com.example.job_portal_system.dao;

import com.example.job_portal_system.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationDAO {
    Application save(Application application);
    Optional<Application> findById(Long id);
    List<Application> findByApplicantUsername(String username);
    List<Application> findByJobId(Long jobId);
    List<Application> findAll();
}
