package com.example.job_portal_system.dao;

import com.example.job_portal_system.model.Application;
import com.example.job_portal_system.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Optional<Application> findById(Long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public List<Application> findByApplicantUsername(String username) {
        return applicationRepository.findByApplicantUsername(username);
    }

    @Override
    public List<Application> findByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}
