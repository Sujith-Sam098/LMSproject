package com.project.LMS.service;

import com.project.LMS.model.Course;
import com.project.LMS.model.Professor;
import com.project.LMS.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseService courseService;  // To interact with courses

    // Register or create a new professor (this can only be done by an Admin)
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    // Get a professor by ID
    public Professor getProfessorById(String id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    // Update a professor's profile
    public Professor updateProfessor(String professorId, Professor updatedProfessor) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        professor.setName(updatedProfessor.getName());
        professor.setDepartment(updatedProfessor.getDepartment());

        return professorRepository.save(professor);
    }

    // Get courses created by a professor
    public List<Course> getCreatedCourses(String professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        return courseService.getCoursesByProfessor(professorId);
    }

    // Add a course to a professor's createdCourses list
    public void addCreatedCourse(String professorId, String courseId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        if (!professor.getCreatedCourses().contains(courseId)) {
            professor.getCreatedCourses().add(courseId);
            professorRepository.save(professor);  // Update the professor's record
        }
    }

    // Access the community forum (after RabbitMQ triggers)
    public void accessForum(String professorId, String courseId) {
        // Logic to access the forum could involve RabbitMQ to grant access
        // Example: Sending a message to RabbitMQ indicating the professor joins the forum
    }


    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}
