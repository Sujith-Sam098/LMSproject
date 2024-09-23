package com.project.LMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "admins")
public class Admin {

    @Id
    private String id;

    private String name;               // Admin's full name
    private String email;              // Email used for login
    private String password;           // Encrypted password
    private Set<String> roles;         // Typically ROLE_ADMIN

}
