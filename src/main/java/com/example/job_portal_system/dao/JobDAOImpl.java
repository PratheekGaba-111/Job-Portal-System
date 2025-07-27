package com.example.job_portal_system.dao;

import com.example.job_portal_system.model.Job;
import com.example.job_portal_system.model.User;
import com.example.job_portal_system.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JobDAOImpl implements JobDAO {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public List<Job> findByPostedBy(User user) {
        return jobRepository.findByPostedBy(user);
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }
}
