package com.project.LMS.dto;

import java.util.List;

public record CourseDto(
     String title,
     String description,
     List<String> videoUrls)
{
}
