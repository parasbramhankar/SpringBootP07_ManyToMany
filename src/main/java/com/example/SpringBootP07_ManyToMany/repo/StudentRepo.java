package com.example.SpringBootP07_ManyToMany.repo;

import com.example.SpringBootWithDBRevision_P02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
