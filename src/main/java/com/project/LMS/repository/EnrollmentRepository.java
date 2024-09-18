package com.project.LMS.repository;

import com.project.LMS.model.Enrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    public Enrollment findByCoursename(String coursename);

    public Enrollment findByCourseid(String courseid);

    public List<Enrollment> findByEnrolledusername(String enrolledusername);

    public List<Enrollment> findByEnrolleduserid(String enrolleduserid);

    public List<Enrollment> findByEnrolledusertype(String enrolledusertype);

    public List<Enrollment> findByInstructorname(String instructorname);

    public List<Enrollment> findByInstructorinstitution(String instructorinstitution);

    public List<Enrollment> findByEnrolleddate(String enrolleddate);

    public List<Enrollment> findByCoursetype(String coursetype);

    public List<Enrollment> findByYoutubeurl(String youtubeurl);

    public List<Enrollment> findByWebsiteurl(String websiteurl);

    @Transactional
    @Modifying
    public void updateEnrolledcount(int enrolledcount, String coursename);
}
