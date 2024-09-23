package com.project.LMS.repository;

import com.project.LMS.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByEmail(String email);  // Find an admin by email (useful for login)

}
