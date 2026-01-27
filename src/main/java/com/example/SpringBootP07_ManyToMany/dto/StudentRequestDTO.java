package com.example.SpringBootP07_ManyToMany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    private String name;
    private LocalDate dob;
    private List<CourseRequestDTO>courses;
}
