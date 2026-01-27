package com.example.SpringBootP07_ManyToMany.controller;

import com.example.SpringBootWithDBRevision_P02.dto.StudentResponseDTO;
import com.example.SpringBootWithDBRevision_P02.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<StudentResponseDTO>>getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
