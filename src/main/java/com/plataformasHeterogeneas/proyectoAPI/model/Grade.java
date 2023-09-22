package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeID;

    private Long studentID;
    private Long courseID;
    private int quarter;
    private int score;

    public int getScore() {
        return 0;
    }

    public void setScore(int finalScoreValue) {
    }

    public void setStudentID(Long studentId) {
    }

    public void setCourseID(Long courseId) {
    }

    public void setQuarter(int i) {
    }

    // Getters and setters
}
