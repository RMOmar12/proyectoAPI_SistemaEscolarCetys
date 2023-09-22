package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;
import java.util.List;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;
}
