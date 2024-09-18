package com.project.LMS.service;


import com.project.LMS.model.Enrollment;
import com.project.LMS.repository.EnrollmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EnrollmentServiceTest {
    @Mock
    EnrollmentRepository enrollmentRepo;

    @InjectMocks
    EnrollmentService enrollmentService;

    private Enrollment enrollment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        enrollment = new Enrollment(); // Initialize with necessary fields
    }

    @Test
    void testSaveEnrollment() {
        when(enrollmentRepo.save(enrollment)).thenReturn(enrollment);

        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);

        assertEquals(enrollment, savedEnrollment);
        verify(enrollmentRepo).save(enrollment);
    }
    @Test
    void testAddNewEnrollment() {
        when(enrollmentRepo.save(enrollment)).thenReturn(enrollment);

        Enrollment newEnrollment = enrollmentService.addNewEnrollment(enrollment);

        assertEquals(enrollment, newEnrollment);
        verify(enrollmentRepo).save(enrollment);
    }

    @Test
    void testGetAllEnrollments() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findAll()).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.getAllEnrollments();

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findAll();
    }

    @Test
    void testUpdateEnrolledCount() {
        enrollment.setCourseName("Course1");
        enrollment.setEnrolledcount("5");
        when(enrollmentRepo.findByCourseName("Course1")).thenReturn(enrollment);

        enrollmentService.updateEnrolledcount("Course1", 10);

        assertEquals("10", enrollment.getEnrolledcount());
        verify(enrollmentRepo).save(enrollment);
    }
    @Test
    void testUpdateEnrolledCount_FalseHit() {
        when(enrollmentRepo.findByCourseName("NonExistentCourse")).thenReturn(null);

        enrollmentService.updateEnrolledcount("NonExistentCourse", 10);

        // Verify that save is never called since the enrollment was not found
        verify(enrollmentRepo, never()).save(any(Enrollment.class));
    }

    @Test
    void testFetchByCourseName() {
        when(enrollmentRepo.findByCourseName("Course1")).thenReturn(enrollment);

        Enrollment result = enrollmentService.fetchByCoursename("Course1");

        assertEquals(enrollment, result);
        verify(enrollmentRepo).findByCourseName("Course1");
    }

    @Test
    void testFetchByCourseId() {
        when(enrollmentRepo.findByCourseId("123")).thenReturn(enrollment);

        Enrollment result = enrollmentService.fetchByCourseid("123");

        assertEquals(enrollment, result);
        verify(enrollmentRepo).findByCourseId("123");
    }

    @Test
    void testFetchByEnrolledUsername() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByEnrolledusername("user1")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByEnrolledusername("user1");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByEnrolledusername("user1");
    }

    @Test
    void testFetchByEnrolledUserId() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByEnrolleduserid("userid1")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByEnrolleduserid("userid1");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByEnrolleduserid("userid1");
    }

    @Test
    void testFetchByEnrolledUserType() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByEnrolledusertype("student")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByEnrolledusertype("student");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByEnrolledusertype("student");
    }

    @Test
    void testFetchByInstructorName() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByInstructorname("Instructor1")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByInstructorname("Instructor1");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByInstructorname("Instructor1");
    }

    @Test
    void testFetchByInstructorInstitution() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByInstructorinstitution("Institution1")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByInstructorinstitution("Institution1");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByInstructorinstitution("Institution1");
    }

    @Test
    void testFetchByEnrolledDate() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByEnrolledDate("2024-01-01")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByEnrolleddate("2024-01-01");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByEnrolledDate("2024-01-01");
    }

    @Test
    void testFetchByCourseType() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByCoursetype("Online")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByCoursetype("Online");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.getFirst());
        verify(enrollmentRepo).findByCoursetype("Online");
    }

    @Test
    void testFetchByYoutubeUrl() {
        List<Enrollment> enrollments = Collections.singletonList(enrollment);
        when(enrollmentRepo.findByYoutubeurl("https://youtube.com")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByYoutubeurl("https://youtube.com");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.get(0));
        verify(enrollmentRepo).findByYoutubeurl("https://youtube.com");
    }

    @Test
    void testFetchByWebsiteUrl() {
        List<Enrollment> enrollments = Arrays.asList(enrollment);
        when(enrollmentRepo.findByWebsiteurl("https://example.com")).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.fetchByWebsiteurl("https://example.com");

        assertEquals(1, result.size());
        assertEquals(enrollment, result.get(0));
        verify(enrollmentRepo).findByWebsiteurl("https://example.com");
    }
}
