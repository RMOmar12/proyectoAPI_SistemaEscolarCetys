package com.plataformasHeterogeneas.proyectoAPI.model;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String professorName;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<ProfessorCourse> professorCourses;

    // Getters and setters
}