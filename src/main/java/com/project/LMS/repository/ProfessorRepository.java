package com.project.LMS.repository;

import com.project.LMS.model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProfessorRepository extends MongoRepository<Professor, String> {

    Optional<Professor> findByEmail(String email);  // Find a professor by their email

}
