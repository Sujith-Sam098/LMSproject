package com.project.LMS.controller;

import com.project.LMS.dto.UserDTO;
import com.project.LMS.model.User;
import com.project.LMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public void greet(){
        System.out.println("Login was successful");
    }
    // Register a new user (OAuth2 flow handled by OAuth2UserService)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDto) {
        User user = userService.registerUser(userDto);
        return ResponseEntity.ok(user);
    }

    // Get the list of courses a user is enrolled in
    @GetMapping("/{userId}/courses")
    public ResponseEntity<?> getEnrolledCourses(@PathVariable String userId) {
        List<String> enrolledCourses = userService.getEnrolledCourses(userId);
        return ResponseEntity.ok(enrolledCourses);
    }

    // Enroll in a course
    @PostMapping("/{userId}/courses/enroll")
    public ResponseEntity<?> enrollInCourse(@PathVariable String userId, @RequestBody String courseId) {
        User user = userService.enrollInCourse(userId, courseId);
        return ResponseEntity.ok(user);
    }

    // Drop a course
    @PostMapping("/{userId}/courses/drop")
    public ResponseEntity<?> dropCourse(@PathVariable String userId, @RequestBody String courseId) {
        User user = userService.dropCourse(userId, courseId);
        return ResponseEntity.ok(user);
    }
}

