package com.project.LMS.controller;

import com.project.LMS.dto.CourseDto;
import com.project.LMS.model.Course;
import com.project.LMS.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {

        @Autowired
        private CourseService courseService;

        // Create a new course (professor only)
        @PostMapping("/create")
        public ResponseEntity<?> createCourse(@RequestParam String professorId, @RequestBody CourseDto courseDTO) {
            Course course = courseService.createCourse(professorId, courseDTO);
            return ResponseEntity.ok(course);
        }

        // Update a course (professor only)
        @PutMapping("/{courseId}/update")
        public ResponseEntity<?> updateCourse(@PathVariable String courseId, @RequestParam String professorId, @RequestBody CourseDto courseDTO) {
            Course course = courseService.updateCourse(courseId, courseDTO);
            return ResponseEntity.ok(course);
        }

        // Delete a course (professor only)
        @DeleteMapping("/{courseId}/delete")
        public ResponseEntity<?> deleteCourse(@PathVariable String courseId, @RequestParam String professorId) {
            courseService.deleteCourse(courseId, professorId);
            return ResponseEntity.ok("Course deleted successfully");
        }

        // Get all courses (open to all users)
        @GetMapping("/all")
        public ResponseEntity<?> getAllCourses() {
            List<Course> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }

        // Get courses created by a professor (professor-specific)
        @GetMapping("/professor/{professorId}")
        public ResponseEntity<?> getCoursesByProfessor(@PathVariable String professorId) {
            List<Course> courses = courseService.getCoursesByProfessor(professorId);
            return ResponseEntity.ok(courses);
        }

        // Get courses enrolled by a user (user-specific)
//        @GetMapping("/user/{userId}")
//        public ResponseEntity<?> getCoursesByUser(@PathVariable String userId) {
//            List<Course> courses = courseService.getCoursesByUser(userId);
//            return ResponseEntity.ok(courses);
}

