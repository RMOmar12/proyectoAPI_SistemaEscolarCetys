package com.plataformasHeterogeneas.proyectoAPI.repository;

import com.plataformasHeterogeneas.proyectoAPI.model.Alumno;
import com.plataformasHeterogeneas.proyectoAPI.model.AlumnoModel;
//import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoModel, Long> {

    Optional<AlumnoModel> findByNombre(String nombre);

    void deleteByNombre(String nombre);



}
