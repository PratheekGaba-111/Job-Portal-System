package com.example.job_portal_system.service;

import com.example.job_portal_system.dao.JobDAO;
import com.example.job_portal_system.model.Job;
import com.example.job_portal_system.model.User;
import com.example.job_portal_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDAO;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createJob(Job job, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        job.setPostedBy(user);
        jobDAO.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobDAO.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        return jobDAO.findById(id);
    }

    @Override
    public List<Job> getJobsByEmployer(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jobDAO.findByPostedBy(user);
    }

    @Override
    public void deleteJob(Long id) {
        jobDAO.deleteById(id);
    }
}
