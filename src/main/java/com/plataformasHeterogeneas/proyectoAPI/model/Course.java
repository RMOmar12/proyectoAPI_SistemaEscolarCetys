package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private int semester;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major major;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<ProfessorCourse> professorCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    public void setCourseID(Long id) {
    }

    // Getters and setters
}
