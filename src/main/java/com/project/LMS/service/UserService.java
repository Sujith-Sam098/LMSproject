package com.project.LMS.service;

import com.project.LMS.dto.UserDto;
import com.project.LMS.model.User;
import com.project.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    // Register a new user (OAuth2 flow)
    public User registerOAuthUser(String uname, String fname, String lname, String email, String college, String provider) {
        User user = new User();
        user.setUsername(uname);
        user.setFirstname(fname);
        user.setLastname(lname);
        user.setEmail(email);
        user.setCollege(college);
        user.setOauthProvider(provider);
        user.setRoles(Set.of("ROLE_USER"));
        return userRepository.save(user);
    }
    // Enroll a user in a course
    public User enrollInCourse(String userId, String courseId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getEnrolledcourses().contains(courseId)) {
            user.getEnrolledcourses().add(courseId);
        }
        return userRepository.save(user);
    }

    //Drop out a user from course
    public User dropCourse(String userId, String courseId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getEnrolledcourses().remove(courseId);
        return userRepository.save(user);
    }
    // Find user by email (for OAuth2 or form login)
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    // Get a list of courses the user is enrolled in
    public List<String> getEnrolledCourses(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getEnrolledcourses();
    }

    //Find by username
    public Optional<User> findByUsername(String username)
    {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    // Register a user through login form
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setFirstname(userDto.firstname());
        user.setLastname(userDto.lastname());
        user.setEmail(userDto.email());
        user.setCollege(userDto.college());
       // user.setPassword(passwordEncoder.encode(userDto.password()));  // Hash password
        user.setRoles(Set.of("ROLE_USER"));
        return userRepository.save(user);
    }
}
