package com.project.LMS.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CourseForumListener {
    @RabbitListener(queues = "forumQueue")
    public void receiveMessage(String message) {
        System.out.println("Received Message: " + message);
        // Process the message (e.g., store it in a MongoDB collection for the course forum)
    }
}
