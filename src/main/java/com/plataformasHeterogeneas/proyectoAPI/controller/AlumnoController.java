package com.plataformasHeterogeneas.proyectoAPI.controller;

import com.plataformasHeterogeneas.proyectoAPI.model.Alumno;
import com.plataformasHeterogeneas.proyectoAPI.model.AlumnoModel;
import com.plataformasHeterogeneas.proyectoAPI.service.AlumnoServicelmpl;
//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO
@RestController
@CrossOrigin
@RequestMapping("/alumnoscv")
public class AlumnoController {

    @Autowired
    private AlumnoServicelmpl alumnoServicelmpl;

    @GetMapping("/getall")//todoooo de la base
    public List<AlumnoModel> getAllUsers() {
        return alumnoServicelmpl.findAll();
    }

    @GetMapping("/getNames")//todoooo de la base
    public List<String> getNames() {
        return alumnoServicelmpl.findNames();
    }

    @PostMapping("/create")//obtener info del formulario
    public ResponseEntity<AlumnoModel> createUser(@RequestBody AlumnoModel user) {
        AlumnoModel createdUser = alumnoServicelmpl.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> eliminarCV(@PathVariable Long id) {
        if (alumnoServicelmpl.eliminarCV(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<AlumnoModel> obtenerCV(@PathVariable Long id) {
        AlumnoModel cv = alumnoServicelmpl.obtenerCVPorId(id);
        if (cv == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

//    @PutMapping("/update/{nombre}")
//    public ResponseEntity<AlumnoModel> actualizarCV(@PathVariable Long id, @RequestBody AlumnoModel cv) {
//        AlumnoModel cvActualizado = alumnoServicelmpl.actualizarCV(id, cv);
//        if (cvActualizado == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cvActualizado, HttpStatus.OK);
//    }
//
//    @PutMapping("/updateByname/{name}")
//    public ResponseEntity<AlumnoModel> updateCVFieldsByName(@PathVariable String name, @RequestBody AlumnoModel cv) {
//        AlumnoModel cvActualizado = alumnoServicelmpl.actualizarCV(name, cv);
//        if (cvActualizado == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cvActualizado, HttpStatus.OK);
//    }

    @PutMapping("/update/{name}")
    public ResponseEntity<AlumnoModel> updateCVFieldsByName(@PathVariable String name, @RequestBody AlumnoModel updatedCV) {
        AlumnoModel cvToUpdate = alumnoServicelmpl.getCVByName(name);
        if (cvToUpdate != null) {
            cvToUpdate.updateFieldsByName(
                    updatedCV.getAbout(),
                    updatedCV.getCarrera(),
                    updatedCV.getDireccion(),
                    updatedCV.getEmail()
                    /* other fields */);
            alumnoServicelmpl.saveCV(cvToUpdate);
            return ResponseEntity.ok(cvToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity<String> eliminarUsuarioPorNombre(@PathVariable String nombre) {
        alumnoServicelmpl.eliminarPorNombre(nombre);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }

    @GetMapping("/{nombre}")
    public Optional findByNombre(@PathVariable String nombre) {
        return alumnoServicelmpl.findByNombre(nombre);
    }


}

