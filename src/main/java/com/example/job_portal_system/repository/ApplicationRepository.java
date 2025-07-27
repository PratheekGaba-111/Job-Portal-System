package com.example.job_portal_system.repository;

import com.example.job_portal_system.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByApplicantUsername(String username);
    List<Application> findByJobId(Long jobId);
}
