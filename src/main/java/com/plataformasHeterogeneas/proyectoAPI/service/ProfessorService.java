package com.plataformasHeterogeneas.proyectoAPI.service;

import com.plataformasHeterogeneas.proyectoAPI.model.Professor;
import com.plataformasHeterogeneas.proyectoAPI.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) {
        return professor;
    }

    public List<Professor> getAllProfessors() {
        return null;
    }

    public Professor getProfessorById(Long id) {
        return null;
    }

    public Professor updateProfessor(Long id, Professor professor) {
        return professor;
    }

    public void deleteProfessor(Long id) {
    }
    // Implement CRUD operations and business logic
}
