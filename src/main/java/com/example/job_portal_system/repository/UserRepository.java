package com.example.job_portal_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.job_portal_system.model.*;

import java.util.Optional;
import java.util.List;
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
    List<User> findByRole(String role);

}
