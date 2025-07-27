package com.example.job_portal_system.dao;

import com.example.job_portal_system.model.User;
import com.example.job_portal_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
    private UserRepository userRepository;

	@Override
	    public void save(User user) {
	        userRepository.save(user);
	    }

	    @Override
	    public Optional<User> findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
	
}
