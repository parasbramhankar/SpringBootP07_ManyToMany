package com.example.SpringBootP07_ManyToMany.service.impl;

import com.example.SpringBootP07_ManyToMany.dto.CourseRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.CourseResponseDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentResponseDTO;
import com.example.SpringBootP07_ManyToMany.entity.Course;
import com.example.SpringBootP07_ManyToMany.entity.Student;
import com.example.SpringBootP07_ManyToMany.repo.StudentRepo;
import com.example.SpringBootP07_ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentResponseDTO> getAllStudents(){
        List<Student>students=studentRepo.findAll();
        List<StudentResponseDTO>responseDTOList=new ArrayList<>();

        for(Student s:students){
            StudentResponseDTO dto=new StudentResponseDTO();

            dto.setId(s.getId());
            dto.setName(s.getName());
            dto.setDOB(s.getDob());

            /*List<CourseResponseDTO>courseList=new ArrayList<>();
            for(Course c:s.getCourses()){
                CourseResponseDTO courseResponseDTO=new CourseResponseDTO(c.getCourse_id(),c.getName());
                courseList.add(courseResponseDTO);
            }*/

            List<CourseResponseDTO>courseList=s.getCourses().stream().map(c->new CourseResponseDTO(c.getCourse_id(),c.getName())).toList();

            dto.setCourses(courseList);

            responseDTOList.add(dto);
        }

        return responseDTOList;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO dto){
        Student student=new Student();
        student.setName(dto.getName());

        Set<Course>courseSet=new HashSet<>();

        for(CourseRequestDTO c:dto.getCourses()){


            courseSet.add(course);
        }



    }


}
