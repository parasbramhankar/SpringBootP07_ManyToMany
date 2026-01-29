package com.example.SpringBootP07_ManyToMany.controller;

import com.example.SpringBootP07_ManyToMany.dto.CourseRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.CourseResponseDTO;
import com.example.SpringBootP07_ManyToMany.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @PostMapping("/save")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO dto) {

        CourseResponseDTO courseResponseDTO = courseService.createCourse(dto);

        return ResponseEntity.ok(courseResponseDTO);
    }

    @GetMapping("/allCourse")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        List<CourseResponseDTO> courseResponseDTOList = courseService.getAllCourses();

        return ResponseEntity.ok(courseResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable int id) {
        CourseResponseDTO courseResponseDTO = courseService.getCourseById(id);

        return ResponseEntity.ok(courseResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(
            @PathVariable int id,
            @RequestBody CourseRequestDTO dto) {

        return ResponseEntity.ok(courseService.updateCourse(id, dto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourseName(
            @PathVariable int id,
            @RequestBody String name) {

        return ResponseEntity.ok(courseService.updateCourseName(id, name));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
