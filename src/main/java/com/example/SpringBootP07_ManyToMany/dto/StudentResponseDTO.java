package com.example.SpringBootP07_ManyToMany.dto;

import com.example.SpringBootP07_ManyToMany.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private int id;
    private String name;
    private LocalDate DOB;
    private List<CourseResponseDTO>courses;
}
