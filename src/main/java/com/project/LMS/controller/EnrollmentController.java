package com.project.LMS.controller;

import com.project.LMS.model.Course;
import com.project.LMS.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")

public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Enroll in a course
    @PostMapping("/enroll")
    public ResponseEntity<?> enrollInCourse(@RequestParam String userId, @RequestParam String courseId) {
        enrollmentService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok("User enrolled in course successfully.");
    }

    // Drop out of a course
    @PostMapping("/drop")
    public ResponseEntity<?> dropCourse(@RequestParam String userId, @RequestParam String courseId) {
        enrollmentService.dropUserFromCourse(userId, courseId);
        return ResponseEntity.ok("User dropped from course successfully.");
    }

    // Get a list of courses a user is enrolled in
    @GetMapping("/user/{userId}/courses")
    public ResponseEntity<?> getUserEnrolledCourses(@PathVariable String userId) {
        List<Course> courses = enrollmentService.getUserEnrolledCourses(userId);
        return ResponseEntity.ok(courses);
    }
}
