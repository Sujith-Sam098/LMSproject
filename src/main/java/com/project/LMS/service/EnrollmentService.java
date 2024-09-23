package com.project.LMS.service;

import com.project.LMS.model.Course;
import com.project.LMS.model.User;
import com.project.LMS.repository.CourseRepository;
import com.project.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Enroll a user in a course
    public void enrollUserInCourse(String userId, String courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Add course to user's enrolledCourses if not already enrolled
        if (!user.getEnrolledcourses().contains(courseId)) {
            user.getEnrolledcourses().add(courseId);
            userRepository.save(user);  // Save updated user data
        }

        // Add user to course's enrolledUsers if not already enrolled
        if (!course.getEnrolledUsers().contains(userId)) {
            course.getEnrolledUsers().add(userId);
            courseRepository.save(course);  // Save updated course data
        }
    }

    // Drop a user from a course
    public void dropUserFromCourse(String userId, String courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Remove course from user's enrolledCourses
        if (user.getEnrolledcourses().contains(courseId)) {
            user.getEnrolledcourses().remove(courseId);
            userRepository.save(user);  // Save updated user data
        }

        // Remove user from course's enrolledUsers
        if (course.getEnrolledUsers().contains(userId)) {
            course.getEnrolledUsers().remove(userId);
            courseRepository.save(course);  // Save updated course data
        }
    }

    // Get courses enrolled by a user
    public List<Course> getUserEnrolledCourses(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<String> enrolledCourseIds = user.getEnrolledcourses();
        return courseRepository.findByIdIn(enrolledCourseIds);
    }

}
