package com.project.LMS.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Enrollment")
public class Enrollment {
    @Id
    private String id;
    private String courseName;
    private String courseId;
    private String enrolledDate;
    private String enrolledusername;
    private String enrolleduserid;
    private String enrolledusertype;
    private String instructorname;
    private String instructorinstitution;
    private String enrolledcount;
    private String youtubeurl;
    private String websiteurl;
    private String coursetype;
    private String description;
}
