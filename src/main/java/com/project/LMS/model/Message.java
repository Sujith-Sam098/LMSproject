package com.project.LMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String courseId;
    private String content;
    private String sender;

    // Getters and setters

}
