package com.plataformasHeterogeneas.proyectoAPI.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProgramMajor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programMajorId;

    @ManyToOne
    @JoinColumn(name = "programId")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major major;

    // Getters and setters
}