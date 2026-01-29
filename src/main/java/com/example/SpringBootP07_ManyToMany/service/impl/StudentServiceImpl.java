package com.example.SpringBootP07_ManyToMany.service.impl;

import com.example.SpringBootP07_ManyToMany.Exception.StudentNotFoundException;
import com.example.SpringBootP07_ManyToMany.dto.CourseRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.CourseResponseDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentRequestDTO;
import com.example.SpringBootP07_ManyToMany.dto.StudentResponseDTO;
import com.example.SpringBootP07_ManyToMany.entity.Course;
import com.example.SpringBootP07_ManyToMany.entity.Student;
import com.example.SpringBootP07_ManyToMany.repo.CourseRepo;
import com.example.SpringBootP07_ManyToMany.repo.StudentRepo;
import com.example.SpringBootP07_ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

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

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto){
        Student student=new Student();
        student.setName(dto.getName());
        student.setDob(dto.getDob());

        Set<Course>courseSet=new HashSet<>();

        for(CourseRequestDTO c:dto.getCourses()){
            Course course=courseRepo.findByName(c.getName()).orElseGet(()->{
                Course newCourse=new Course();
                newCourse.setName(c.getName());
                return courseRepo.save(newCourse);
            });
            courseSet.add(course);
        }
        student.setCourses(courseSet);

        Student saveStudent=studentRepo.save(student);

        return mapToResponseDTO(saveStudent);
    }

    public StudentResponseDTO mapToResponseDTO(Student student){
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setDOB(student.getDob());

        List<CourseResponseDTO>courseDTO=student.getCourses().stream().map(c->
                new CourseResponseDTO(c.getCourse_id(),c.getName())).toList();
        studentResponseDTO.setCourses(courseDTO);

        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudentById(int id){
        Student student=studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not found: "+id));

        return mapToResponseDTO(student);

    }


    @Override
    public StudentResponseDTO updateStudent(int id, StudentRequestDTO studentRequestDTO){
        Student student=studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found: "+id));

        student.setName(studentRequestDTO.getName());
        student.setDob(studentRequestDTO.getDob());

        Set<Course>courses=new HashSet<>();

        for(CourseRequestDTO c:studentRequestDTO.getCourses()){
            Course course=courseRepo.findByName(c.getName()).orElseGet(()->{
                Course newCourse=new Course();
                newCourse.setName(c.getName());
                return courseRepo.save(newCourse);
            });
            courses.add(course);
        }

        student.setCourses(courses);

        Student saveStudent=studentRepo.save(student);

        return mapToResponseDTO(saveStudent);
    }

    @Override
    public StudentResponseDTO updateDOB(int id, LocalDate date){
        Student student=studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found: "+id));
        student.setDob(date);

        Student save=studentRepo.save(student);

        return mapToResponseDTO(save);
    }

    @Override
    public void deleteStudent(int id){
        Student student=studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found: "+id));

        studentRepo.delete(student);
    }

}
