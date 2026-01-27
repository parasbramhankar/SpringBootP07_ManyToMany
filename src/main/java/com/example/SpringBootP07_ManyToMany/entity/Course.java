package com.example.SpringBootP07_ManyToMany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student>students=new HashSet<>();
}
