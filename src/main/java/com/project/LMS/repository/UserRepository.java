package com.project.LMS.repository;

import com.project.LMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String > {

    public User findByEmail(String email);

    public User findByUsername(String UserName);

}
