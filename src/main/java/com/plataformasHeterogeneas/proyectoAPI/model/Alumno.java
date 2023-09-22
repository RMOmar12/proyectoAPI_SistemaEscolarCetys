package com.plataformasHeterogeneas.proyectoAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO
@JsonSerialize
public class Alumno implements Serializable
{
    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("about")
    private String about;
    @JsonProperty("carrera")
    private String carrera;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("email")
    private String email;


    public Alumno() {
    }
    public Alumno( long id, String nombre,String about, String carrera,String direccion, String email) {
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



}
