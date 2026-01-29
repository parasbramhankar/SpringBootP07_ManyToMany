package com.example.SpringBootP07_ManyToMany.repo;

import com.example.SpringBootP07_ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course,Integer> {

    Optional<Course>findByName(String name);
}
