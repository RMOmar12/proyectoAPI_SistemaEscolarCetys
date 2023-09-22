package com.plataformasHeterogeneas.proyectoAPI.repository;

import com.plataformasHeterogeneas.proyectoAPI.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
