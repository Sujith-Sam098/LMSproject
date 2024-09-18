package com.project.LMS.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String gender;
    private String email;
    private String mobile;
    private String college;
    private String password;
}
