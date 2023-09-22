package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

@Entity
public class ProfessorCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorCourseId;

    @ManyToOne
    @JoinColumn(name = "professorId")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    // Getters and setters
}