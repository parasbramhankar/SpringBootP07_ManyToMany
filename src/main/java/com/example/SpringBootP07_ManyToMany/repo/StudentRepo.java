package com.example.SpringBootP07_ManyToMany.repo;

import com.example.SpringBootP07_ManyToMany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
