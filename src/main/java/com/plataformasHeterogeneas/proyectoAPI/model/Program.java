package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    private String programName;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<ProgramMajor> programMajors;

    // Getters and setters
}