package com.example.SpringBootP07_ManyToMany.repo;

import com.example.SpringBootP07_ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
