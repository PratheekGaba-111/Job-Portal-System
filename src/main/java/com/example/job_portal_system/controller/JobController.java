package com.example.job_portal_system.controller;

import com.example.job_portal_system.model.Job;
import com.example.job_portal_system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // ✅ Only EMPLOYERS can post jobs
    @PostMapping
    @PreAuthorize("hasRole('EMPLOYER')")
    public ResponseEntity<String> createJob(@RequestBody Job job, Principal principal) {
        String username = principal.getName(); // Logged-in user's username
        jobService.createJob(job, username);
        return ResponseEntity.ok("Job posted successfully!");
    }

    // ✅ Public: Anyone can view all jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // ✅ Public: Anyone can view jobs by a specific employer
    @GetMapping("/employer/{username}")
    public ResponseEntity<List<Job>> getJobsByEmployer(@PathVariable String username) {
        return ResponseEntity.ok(jobService.getJobsByEmployer(username));
    }

    // ✅ Public: Anyone can view a job by ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Only EMPLOYERS can delete jobs
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully!");
    }
}
