package com.project.LMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    @Id
    private String id;
    private String title;               // Course title
    private String description;         // Course description
    private String professorId;         // Reference to the professor who created the course
    private List<String> videoUrls;     // List of embedded YouTube video URLs

    private List<String> enrolledUsers = new ArrayList<>();
}
