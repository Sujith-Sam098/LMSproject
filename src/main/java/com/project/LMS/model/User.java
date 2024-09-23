package com.project.LMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")

public class User {
    @Id
    private String userId;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String college;
    private String password;
    private Set<String> roles;
    private List<String> enrolledcourses = new ArrayList<>();
    // OAuth2 provider information (for regular users)
    private String oauthProvider;  // Google, Facebook, etc.
}
