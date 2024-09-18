package com.project.LMS.service;

import com.project.LMS.model.Enrollment;
import com.project.LMS.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepo;

    public Enrollment saveEnrollment(Enrollment enrollment)
    {
        return enrollmentRepo.save(enrollment);
    }

    public Enrollment addNewEnrollment(Enrollment enrollment)
    {
        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments()
    {
        return (List<Enrollment>)enrollmentRepo.findAll();
    }

    public void updateEnrolledcount(String coursename, int enrolledcount)
    {
        enrollmentRepo.updateEnrolledcount(enrolledcount, coursename);
    }

    public Enrollment fetchByCoursename(String coursename)
    {
        return enrollmentRepo.findByCoursename(coursename);
    }

    public Enrollment fetchByCourseid(String courseid)
    {
        return enrollmentRepo.findByCourseid(courseid);
    }

    public List<Enrollment> fetchByEnrolledusername(String enrolledusername)
    {
        return (List<Enrollment>)enrollmentRepo.findByEnrolledusername(enrolledusername);
    }

    public List<Enrollment> fetchByEnrolleduserid(String enrolleduserid)
    {
        return (List<Enrollment>)enrollmentRepo.findByEnrolleduserid(enrolleduserid);
    }

    public List<Enrollment> fetchByEnrolledusertype(String enrolledusertype)
    {
        return (List<Enrollment>)enrollmentRepo.findByEnrolledusertype(enrolledusertype);
    }

    public List<Enrollment> fetchByInstructorname(String instructorname)
    {
        return (List<Enrollment>)enrollmentRepo.findByInstructorname(instructorname);
    }

    public List<Enrollment> fetchByInstructorinstitution(String instructorinstitution)
    {
        return (List<Enrollment>)enrollmentRepo.findByInstructorinstitution(instructorinstitution);
    }

    public List<Enrollment> fetchByEnrolleddate(String enrolleddate)
    {
        return (List<Enrollment>)enrollmentRepo.findByEnrolleddate(enrolleddate);
    }

    public List<Enrollment> fetchByCoursetype(String coursetype)
    {
        return (List<Enrollment>)enrollmentRepo.findByCoursetype(coursetype);
    }

    public List<Enrollment> fetchByYoutubeurl(String youtubeurl)
    {
        return (List<Enrollment>)enrollmentRepo.findByYoutubeurl(youtubeurl);
    }

    public List<Enrollment> fetchByWebsiteurl(String websiteurl)
    {
        return (List<Enrollment>)enrollmentRepo.findByWebsiteurl(websiteurl);
    }

}
