package com.plataformasHeterogeneas.proyectoAPI.model;

import jakarta.persistence.*;

//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO


@Entity
@Table(name = "alumnoscv")
public class AlumnoModel {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "about")
    private String about;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;


    public AlumnoModel() {
    }
    public AlumnoModel( long id, String nombre,String about, String carrera,String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.about = about;
        this.carrera = carrera;
        this.direccion = direccion;
        this.email = email;
    }

    public long getId(){return this.id;};
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbout() {
        return this.about;
    }

    public String getCarrera() {
        return this.carrera;
    }
    public void setCarrera(String carrera) { this.carrera = carrera;}

    public void setAbout(String about) { this.about = about;}

    public String getDireccion() {
        return this.direccion;
    }
    public void setDireccion(String direccion) { this.direccion = direccion;}
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) { this.email = email;}

    public void updateFieldsByName(String about, String carrera,String direccion, String email) {
        this.about = about;
        this.carrera = carrera;
        this.direccion = direccion;
        this.email = email;
    }

}
