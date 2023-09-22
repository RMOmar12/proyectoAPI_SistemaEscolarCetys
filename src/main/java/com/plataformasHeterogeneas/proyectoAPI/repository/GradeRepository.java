package com.plataformasHeterogeneas.proyectoAPI.repository;

import com.plataformasHeterogeneas.proyectoAPI.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentIDAndCourseID(Long studentId, Long courseId);
    Grade findByStudentIDAndCourseIDAndQuarter(Long studentId, Long courseId, int quarter);
}
