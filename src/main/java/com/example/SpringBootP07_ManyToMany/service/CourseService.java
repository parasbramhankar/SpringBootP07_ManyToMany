package com.example.SpringBootP07_ManyToMany.service;

import com.example.SpringBootP07_ManyToMany.dto.CourseRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.CourseResponseDTO;

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
