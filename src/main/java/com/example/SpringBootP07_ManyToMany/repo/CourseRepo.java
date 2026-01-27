package com.example.SpringBootP07_ManyToMany.repo;

import com.example.SpringBootWithDBRevision_P02.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
