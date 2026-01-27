package com.example.SpringBootP07_ManyToMany.service;

import com.example.SpringBootP07_ManyToMany.dto.StudentRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    //CREATE
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);

    //READ
     List<StudentResponseDTO>getAllStudents();
     StudentResponseDTO getStudentById(int id);

    //UPDATE
     StudentResponseDTO updateStudent(int id, StudentRequestDTO studentRequestDTO);
     String updateDOB(int id, LocalDate date);

    //DELETE
     String deleteStudent(int id);
}
