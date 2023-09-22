package com.plataformasHeterogeneas.proyectoAPI.service;

import com.plataformasHeterogeneas.proyectoAPI.model.Alumno;
import com.plataformasHeterogeneas.proyectoAPI.model.AlumnoModel;
import com.plataformasHeterogeneas.proyectoAPI.repository.IAlumnoRepository;
//import org.apache.el.stream.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO

@Service
public class AlumnoServicelmpl {

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    public List<AlumnoModel> findAll() {
        return iAlumnoRepository.findAll();
    }
    public AlumnoModel createUser(AlumnoModel user) {
        return iAlumnoRepository.save(user);
    }
    public boolean eliminarCV(Long id) {
        if (iAlumnoRepository.existsById(id)) {
            iAlumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<String> findNames() {
        List<AlumnoModel> userList = iAlumnoRepository.findAll();
        List<String> nameList = new ArrayList<>();
        for(AlumnoModel user : userList) {
            nameList.add(user.getNombre());
        }
        return nameList;
    }

    public AlumnoModel obtenerCVPorId(Long id) {
        Optional<AlumnoModel>  user = iAlumnoRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public  AlumnoModel actualizarCV (String nombre, AlumnoModel user) {
        AlumnoModel cvActualizado = getCVByName(nombre);
        if (cvActualizado == null) {
            return null;
        }
        cvActualizado.setAbout(user.getAbout());
        cvActualizado.setEmail(user.getEmail());
        cvActualizado.setCarrera(user.getCarrera());
        cvActualizado.setDireccion(user.getDireccion());
        return iAlumnoRepository.save(cvActualizado);
    }

    public AlumnoModel getCVByName(String name) {
        Optional<AlumnoModel>  user = iAlumnoRepository.findByNombre(name);
        return user.orElse(null);
    }

    @Transactional
    public void eliminarPorNombre(String nombre) {
        iAlumnoRepository.deleteByNombre(nombre);
    }

    public void saveCV(AlumnoModel cv) {
        iAlumnoRepository.save(cv);
    }
    public Optional<AlumnoModel> findByNombre(String nombre) {
        return iAlumnoRepository.findByNombre(nombre);
    }
}



