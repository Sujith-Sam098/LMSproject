package com.project.LMS.controller;

import com.project.LMS.model.Course;
import com.project.LMS.model.Professor;
import com.project.LMS.service.CourseService;
import com.project.LMS.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Register a new professor (only for admin)
    @PostMapping("/register")
    public ResponseEntity<?> createProfessor(@RequestBody Professor professor) {
        Professor newProfessor = professorService.createProfessor(professor);
        return ResponseEntity.ok(newProfessor);
    }

    // Get a professor's profile
    @GetMapping("/{professorId}")
    public ResponseEntity<?> getProfessorById(@PathVariable String professorId) {
        Professor professor = professorService.getProfessorById(professorId);
        return ResponseEntity.ok(professor);
    }

    // Update professor profile
    @PutMapping("/{professorId}/update")
    public ResponseEntity<?> updateProfessor(@PathVariable String professorId, @RequestBody Professor professor) {
        Professor updatedProfessor = professorService.updateProfessor(professorId, professor);
        return ResponseEntity.ok(updatedProfessor);
    }

    // Get courses created by the professor
    @GetMapping("/{professorId}/courses")
    public ResponseEntity<?> getCreatedCourses(@PathVariable String professorId) {
        List<Course> courses = professorService.getCreatedCourses(professorId);
        return ResponseEntity.ok(courses);
    }

    // Access the community forum for a specific course
    @PostMapping("/{professorId}/forum/{courseId}/access")
    public ResponseEntity<?> accessForum(@PathVariable String professorId, @PathVariable String courseId) {
        professorService.accessForum(professorId, courseId);
        return ResponseEntity.ok("Access to forum granted.");
    }
}