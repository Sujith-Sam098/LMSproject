package com.project.LMS.repository;

import com.project.LMS.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByCourseId(String courseId);

}
