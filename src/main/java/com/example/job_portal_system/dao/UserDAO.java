package com.example.job_portal_system.dao;
import com.example.job_portal_system.model.User;
import java.util.Optional;

public interface UserDAO {
	void save(User user);
	Optional<User> findByUsername(String username);
}
