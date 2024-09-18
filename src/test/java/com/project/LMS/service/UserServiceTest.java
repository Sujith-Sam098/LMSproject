package com.project.LMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.LMS.model.User;
import com.project.LMS.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(); // Initialize with necessary fields
        user.setEmail("test@example.com");
        user.setUsername("testUser");
        user.setPassword("password123");
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertEquals(user, savedUser);
        verify(userRepository).save(user);
    }

    @Test
    void testUpdateUserProfile() {
        when(userRepository.save(user)).thenReturn(user);

        User updatedUser = userService.updateUserProfile(user);

        assertEquals(user, updatedUser);
        verify(userRepository).save(user);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Collections.singletonList(user);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(1, result.size());
        assertEquals(user, result.getFirst());
        verify(userRepository).findAll();
    }

    @Test
    void testFetchUserByEmail_UserExists() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        User fetchedUser = userService.fetchUserByEmail("test@example.com");

        assertEquals(user, fetchedUser);
        verify(userRepository).findByEmail("test@example.com");
    }

    @Test
    void testFetchUserByEmail_UserDoesNotExist() {
        when(userRepository.findByEmail("notfound@example.com")).thenReturn(null);

        User fetchedUser = userService.fetchUserByEmail("notfound@example.com");

        assertNull(fetchedUser);
        verify(userRepository).findByEmail("notfound@example.com");
    }

    @Test
    void testFetchUserByUsername_UserExists() {
        when(userRepository.findByUsername("testUser")).thenReturn(user);

        User fetchedUser = userService.fetchUserByUsername("testUser");

        assertEquals(user, fetchedUser);
        verify(userRepository).findByUsername("testUser");
    }

    @Test
    void testFetchUserByUsername_UserDoesNotExist() {
        when(userRepository.findByUsername("unknownUser")).thenReturn(null);

        User fetchedUser = userService.fetchUserByUsername("unknownUser");

        assertNull(fetchedUser);
        verify(userRepository).findByUsername("unknownUser");
    }

    @Test
    void testFetchUserByEmailAndPassword_UserExists() {
        when(userRepository.findByEmailAndPassword("test@example.com", "password123")).thenReturn(user);

        User fetchedUser = userService.fetchUserByEmailAndPassword("test@example.com", "password123");

        assertEquals(user, fetchedUser);
        verify(userRepository).findByEmailAndPassword("test@example.com", "password123");
    }

    @Test
    void testFetchUserByEmailAndPassword_UserDoesNotExist() {
        when(userRepository.findByEmailAndPassword("test@example.com", "wrongPassword")).thenReturn(null);

        User fetchedUser = userService.fetchUserByEmailAndPassword("test@example.com", "wrongPassword");

        assertNull(fetchedUser);
        verify(userRepository).findByEmailAndPassword("test@example.com", "wrongPassword");
    }
}

