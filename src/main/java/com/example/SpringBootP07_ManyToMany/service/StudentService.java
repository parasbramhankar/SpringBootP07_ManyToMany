package com.example.SpringBootP07_ManyToMany.service;

import com.example.SpringBootWithDBRevision_P02.dto.StudentRequestDTO;
import com.example.SpringBootWithDBRevision_P02.dto.StudentResponseDTO;

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
