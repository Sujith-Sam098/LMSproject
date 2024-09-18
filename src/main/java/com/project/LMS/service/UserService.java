package com.project.LMS.service;

import com.project.LMS.model.User;
import com.project.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public User updateUserProfile(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return (List<User>)userRepository.findAll();
    }

    public User fetchUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User fetchUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User fetchUserByEmailAndPassword(String email, String password)
    {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
