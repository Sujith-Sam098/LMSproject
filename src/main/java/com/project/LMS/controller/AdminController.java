package com.project.LMS.controller;

import com.project.LMS.model.Admin;
import com.project.LMS.model.Professor;
import com.project.LMS.model.User;
import com.project.LMS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register a new admin (this can only be done in system setup)
    @PostMapping("/register")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(newAdmin);
    }

    // Create a new professor
    @PostMapping("/professor/create")
    public ResponseEntity<?> createProfessor(@RequestBody Professor professor) {
        Professor newProfessor = adminService.createProfessor(professor);
        return ResponseEntity.ok(newProfessor);
    }

    // Update user roles (e.g., promote to professor)
    @PutMapping("/user/{userId}/roles")
    public ResponseEntity<?> updateUserRoles(@PathVariable String userId, @RequestBody Set<String> roles) {
        User updatedUser = adminService.updateUserRoles(userId, roles);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        adminService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get all professors
    @GetMapping("/professors")
    public ResponseEntity<?> getAllProfessors() {
        List<Professor> professors = adminService.getAllProfessors();
        return ResponseEntity.ok(professors);
    }


}
