package com.example.job_portal_system.controller;

import com.example.job_portal_system.model.Application;
import com.example.job_portal_system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply/{jobId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> applyToJob(@PathVariable Long jobId, Principal principal) {
        applicationService.applyToJob(jobId, principal.getName());
        return ResponseEntity.ok("Application submitted!");
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    public List<Application> getMyApplications(Principal principal) {
        return applicationService.getApplicationsByApplicant(principal.getName());
    }

    @GetMapping("/job/{jobId}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Application> getApplicationsForJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsForJob(jobId);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @PutMapping("/{applicationId}/status")
    @PreAuthorize("hasAnyRole('EMPLOYER', 'ADMIN')")
    public ResponseEntity<String> updateStatus(@PathVariable Long applicationId,
                                               @RequestParam String status) {
        applicationService.updateApplicationStatus(applicationId, status);
        return ResponseEntity.ok("Application status updated to: " + status.toUpperCase());
    }
}
