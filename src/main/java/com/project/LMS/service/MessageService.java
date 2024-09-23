package com.project.LMS.service;

import com.project.LMS.model.Message;
import com.project.LMS.repository.MessageRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageRepository messageRepository; // MongoDB repository

    public void sendMessageToForum(String courseId, String message) {
        // Send message to RabbitMQ exchange
        rabbitTemplate.convertAndSend("course.forum.exchange", "course.forum." + courseId, message);

        // Save message to MongoDB (for persistence)
        Message messageEntity = new Message(courseId, message, "sender"); // sender can be the current user
        messageRepository.save(messageEntity);
    }

    // Fetch messages for a course
    public List<com.project.LMS.model.Message> getMessagesByCourseId(String courseId) {
        return messageRepository.findByCourseId(courseId);
    }

}
