package com.project.LMS.repository;

import com.project.LMS.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CourseRepository extends MongoRepository<Course, String> {

    List<Course> findByProfessorId(String professorId);
    List<Course> findByIdIn(List<String> courseIds);
}
