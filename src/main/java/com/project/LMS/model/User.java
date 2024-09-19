package com.project.LMS.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private String userId;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String college;
    private String password;
    private Set<String> role;
    private List<String> enrolledcourses = new ArrayList<>();
    // OAuth2 provider information (for regular users)
    private String oauthProvider;  // Google, Facebook, etc.
}
