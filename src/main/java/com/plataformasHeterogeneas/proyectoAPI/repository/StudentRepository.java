package com.plataformasHeterogeneas.proyectoAPI.repository;

import com.plataformasHeterogeneas.proyectoAPI.model.AlumnoModel;
import com.plataformasHeterogeneas.proyectoAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
