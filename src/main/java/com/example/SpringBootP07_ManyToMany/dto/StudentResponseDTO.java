package com.example.SpringBootP07_ManyToMany.dto;

import com.example.SpringBootWithDBRevision_P02.entity.Course;

import java.time.LocalDate;
import java.util.List;

public class StudentResponseDTO {
    private int id;
    private String name;
    private LocalDate DOB;
    private List<Course>courses;
}
