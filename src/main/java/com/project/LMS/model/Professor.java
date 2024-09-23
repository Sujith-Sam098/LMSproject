package com.project.LMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Professor")

public class Professor {
    @Id
    private String id;

    private String name;               // Professor's full name
    private String email;              // Email, also used for login
    private String password;           // Encrypted password
    private Set<String> roles;         // Typically ROLE_PROFESSOR

    private String department;         // Optional: Department where professor teaches
    private List<String> createdCourses = new ArrayList<>();  // Courses created by professor

}
