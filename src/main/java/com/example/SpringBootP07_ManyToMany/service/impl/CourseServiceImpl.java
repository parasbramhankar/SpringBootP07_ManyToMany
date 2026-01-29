package com.example.SpringBootP07_ManyToMany.service.impl;

import com.example.SpringBootP07_ManyToMany.Exception.CourseNotFoundException;
import com.example.SpringBootP07_ManyToMany.dto.CourseRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.CourseResponseDTO;
import com.example.SpringBootP07_ManyToMany.entity.Course;
import com.example.SpringBootP07_ManyToMany.repo.CourseRepo;
import com.example.SpringBootP07_ManyToMany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        Course course=new Course();
        course.setName(dto.getName());
        Course save=courseRepo.save(course);

        return mapToCourseResponseDTO(save);
    }

    public CourseResponseDTO mapToCourseResponseDTO(Course course){
        CourseResponseDTO courseResponseDTO=new CourseResponseDTO();

        courseResponseDTO.setId(course.getCourse_id());
        courseResponseDTO.setName(course.getName());

        return courseResponseDTO;
    }



    @Override
    public List<CourseResponseDTO> getAllCourses() {

        List<Course>courseList=courseRepo.findAll();

        List<CourseResponseDTO>list=new ArrayList<>();

        for(Course c:courseList){
            CourseResponseDTO dto=new CourseResponseDTO();
            dto.setId(c.getCourse_id());
            dto.setName(c.getName());

            list.add(dto);
        }

        return list;
    }

    @Override
    public CourseResponseDTO getCourseById(int id) {
        Course course=courseRepo.findById(id).orElseThrow(()->new CourseNotFoundException("Course not found: "+id));
        return mapToCourseResponseDTO(course);
    }

    @Override
    public CourseResponseDTO updateCourse(int id, CourseRequestDTO dto) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found: " + id));

        // Update fields
        course.setName(dto.getName());

        Course updated = courseRepo.save(course);

        return mapToCourseResponseDTO(updated);
    }


    @Override
    public CourseResponseDTO updateCourseName(int id, String courseName) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found: " + id));

        course.setName(courseName);

        Course updated = courseRepo.save(course);

        return mapToCourseResponseDTO(updated);
    }


    @Override
    public void deleteCourse(int id) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found: " + id));

        courseRepo.delete(course);
    }

}
