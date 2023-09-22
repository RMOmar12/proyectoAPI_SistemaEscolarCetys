package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;

    private String majorName;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL)
    private List<Course> courses;

    // Getters and setters
}


