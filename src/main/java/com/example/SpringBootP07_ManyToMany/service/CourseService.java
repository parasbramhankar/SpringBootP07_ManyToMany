package com.example.SpringBootP07_ManyToMany.service;

import com.example.SpringBootWithDBRevision_P02.dto.CourseRequestDTO;
import com.example.SpringBootWithDBRevision_P02.dto.CourseResponseDTO;

import java.util.List;
import java.util.zip.CheckedOutputStream;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(int id);

    CourseResponseDTO updateCourse(int id, CourseRequestDTO dto);
    CourseResponseDTO updateCourseName(int id, String courseName);

    void deleteCourse(int id);
}
