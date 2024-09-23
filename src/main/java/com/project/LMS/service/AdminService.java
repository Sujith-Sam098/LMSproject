package com.project.LMS.service;

import com.project.LMS.model.Admin;
import com.project.LMS.model.Professor;
import com.project.LMS.model.User;
import com.project.LMS.repository.AdminRepository;
import com.project.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProfessorService professorService;  // To create professors

    @Autowired
    private UserRepository userRepository;      // To manage users

    // Create or register a new admin (for system initialization)
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Create a professor (Admin privilege)
    public Professor createProfessor(Professor professor) {
        return professorService.createProfessor(professor);  // Delegate to ProfessorService
    }

    // Manage user roles (e.g., upgrading/downgrading roles)
    public User updateUserRoles(String userId, Set<String> newRoles) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRoles(newRoles);  // Update roles
        return userRepository.save(user);  // Save updated user
    }

    // Delete a user (Admin privilege)
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);  // Deletes a user by ID
    }

    // Get a list of all users (for admin overview)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a list of all professors (for admin overview)
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();  // Delegate to ProfessorService
    }
}
