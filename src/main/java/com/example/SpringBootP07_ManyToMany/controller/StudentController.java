package com.example.SpringBootP07_ManyToMany.controller;

import com.example.SpringBootP07_ManyToMany.dto.StudentRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentResponseDTO;
import com.example.SpringBootP07_ManyToMany.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

        return ResponseEntity.ok(studentResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        StudentResponseDTO studentResponseDTO = studentService.getStudentById(id);

        return ResponseEntity.ok(studentResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int id, @RequestBody StudentRequestDTO studentRequestDTO) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentRequestDTO);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateDOB(@PathVariable int id, @RequestBody LocalDate date) {
        StudentResponseDTO studentResponseDTO = studentService.updateDOB(id, date);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
