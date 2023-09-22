package com.plataformasHeterogeneas.proyectoAPI.model;
import jakarta.persistence.*;


@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private int semester;

    // Getters and setters
}




