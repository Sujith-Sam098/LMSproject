package com.project.LMS.controller;

import com.project.LMS.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.LMS.model.Message;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/courses/{courseId}/message")
    public ResponseEntity<Void> sendMessage(@PathVariable String courseId, @RequestBody String message) {
        messageService.sendMessageToForum(courseId, message);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/courses/{courseId}/messages")
    public ResponseEntity<List<String>> getMessages(@PathVariable String courseId) {
        List<com.project.LMS.model.Message> messages = messageService.getMessagesByCourseId(courseId);

        // Convert Message objects to a list of message contents (strings)
        List<String> messageContents = messages.stream()
                .map(Message::getContent)
                .collect(Collectors.toList());

        return ResponseEntity.ok(messageContents);
    }
}

