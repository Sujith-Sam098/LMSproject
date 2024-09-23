package com.project.LMS.service;

import com.project.LMS.dto.CourseDto;
import com.project.LMS.model.Course;
import com.project.LMS.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;  // To interact with enrolled users

    // Create a new course (professor)
    public Course createCourse(String professorId, CourseDto courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.title());
        course.setDescription(courseDTO.description());
        course.setProfessorId(professorId);
        course.setVideoUrls(courseDTO.videoUrls());
        return courseRepository.save(course);
    }

    // Update an existing course (professor)
    public Course updateCourse(String courseId, CourseDto courseDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(courseDTO.title());
        course.setDescription(courseDTO.description());
        course.setVideoUrls(courseDTO.videoUrls());

        return courseRepository.save(course);
    }

    // Delete a course (professor)
    public void deleteCourse(String courseId, String professorId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Ensure only the professor who created the course can delete it
        if (!course.getProfessorId().equals(professorId)) {
            throw new RuntimeException("You are not authorized to delete this course.");
        }

        courseRepository.deleteById(courseId);
    }

    // Get a list of all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get a list of courses by professor
    public List<Course> getCoursesByProfessor(String professorId) {
        return courseRepository.findByProfessorId(professorId);
    }

    // Get a list of courses enrolled by a user
//    public List<Course> getCoursesByUser(String userId) {
//        User user = userService.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        List<String> enrolledCourseIds = user.getEnrolledCourses();
//        return courseRepository.findByIdIn(enrolledCourseIds);
//    }

}
