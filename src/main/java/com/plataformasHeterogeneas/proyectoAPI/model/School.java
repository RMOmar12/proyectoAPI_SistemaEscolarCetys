package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private String schoolName;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Major> majors;

    // Getters and setters
}
