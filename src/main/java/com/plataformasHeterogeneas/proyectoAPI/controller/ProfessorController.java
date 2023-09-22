package com.plataformasHeterogeneas.proyectoAPI.controller;

import com.plataformasHeterogeneas.proyectoAPI.model.Professor;
import com.plataformasHeterogeneas.proyectoAPI.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Create a new professor
    @PostMapping("/")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    // Retrieve all professors
    @GetMapping("/")
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Retrieve a professor by ID
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    // Update a professor
    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor);
    }

    // Delete a professor by ID
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}
