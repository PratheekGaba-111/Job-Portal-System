package com.example.job_portal_system.repository;

import com.example.job_portal_system.model.Job;
import com.example.job_portal_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByPostedBy(User user); // Now uses User, not String
}
