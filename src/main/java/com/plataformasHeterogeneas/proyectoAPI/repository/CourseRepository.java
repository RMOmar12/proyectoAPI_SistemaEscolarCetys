package com.plataformasHeterogeneas.proyectoAPI.repository;
import com.plataformasHeterogeneas.proyectoAPI.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}