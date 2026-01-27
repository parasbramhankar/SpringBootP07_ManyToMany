package com.example.SpringBootP07_ManyToMany.service.impl;

import com.example.SpringBootWithDBRevision_P02.dto.StudentResponseDTO;
import com.example.SpringBootWithDBRevision_P02.entity.Student;
import com.example.SpringBootWithDBRevision_P02.repo.StudentRepo;
import com.example.SpringBootWithDBRevision_P02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentResponseDTO> getAllStudents(){
        List<Student>students=studentRepo.findAll();
        List<StudentResponseDTO>responseDTOList=new ArrayList<>();

        for(Student s:students){
            StudentResponseDTO dto=new StudentResponseDTO();


        }
    }
}
