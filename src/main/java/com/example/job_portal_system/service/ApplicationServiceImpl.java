package com.example.job_portal_system.service;

import com.example.job_portal_system.dao.ApplicationDAO;
import com.example.job_portal_system.model.Application;
//import com.example.job_portal_system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationDAO applicationDao;

    @Override
    public Application applyToJob(Long jobId, String applicantUsername) {
        Application application = new Application();
        application.setJobId(jobId);
        application.setApplicantUsername(applicantUsername);
        application.setStatus("APPLIED");
        return applicationDao.save(application);
    }

    @Override
    public List<Application> getApplicationsByApplicant(String username) {
        return applicationDao.findByApplicantUsername(username);
    }

    @Override
    public List<Application> getApplicationsForJob(Long jobId) {
        return applicationDao.findByJobId(jobId);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationDao.findAll();
    }

    @Override
    public void updateApplicationStatus(Long applicationId, String status) {
        Application app = applicationDao.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status.toUpperCase());
        applicationDao.save(app);
    }
}
