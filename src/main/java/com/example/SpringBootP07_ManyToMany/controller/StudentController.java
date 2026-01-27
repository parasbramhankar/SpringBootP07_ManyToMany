package com.example.SpringBootP07_ManyToMany.controller;

import com.example.SpringBootP07_ManyToMany.dto.StudentRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentResponseDTO;
import com.example.SpringBootP07_ManyToMany.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDTO>createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO studentResponseDTO=studentService.createStudent(studentRequestDTO);

    }

}
