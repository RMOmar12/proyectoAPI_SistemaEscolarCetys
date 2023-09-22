package com.plataformasHeterogeneas.proyectoAPI.controller;

import com.plataformasHeterogeneas.proyectoAPI.model.Alumno;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
//NO SE USA: ES EL EJEMPLO DEL PROYECTO PASADO
@RestController
@CrossOrigin
@RequestMapping("/api")

public class ApiDemo {
    static ArrayList<Alumno> alumnos = new ArrayList<>();
    @GetMapping("/saludar")
    public String saludar(){

        return "Este es un demo en API";
    }

    @GetMapping("/llenar")
    public String llenar(){
        alumnos.add(new Alumno(6862381890L,"Mariana","I'm an engineer","ICC", "Clzda Cetys","jeje@gmail.com"));
        alumnos.add(new Alumno(6861180710L,"Daniela","I'm a software developer", "ICC", "Clzda Paris","bla@gmail.com"));
        alumnos.add(new Alumno(6865649811L,"Omar","I'm a Data Scientist", "ICC", "Clzda Roma","okok@gmail.com"));

        return "todos llenos";
    }

    @GetMapping("/all")
    public ArrayList<Alumno> getAlumno(){
        return alumnos;
    }

    @GetMapping("/find/{id}")
    public Alumno getAlumnoById(@PathVariable("id") long id){
        Alumno alumno =null;

        for(Alumno a: alumnos){
            if(a.getId()==id){
                alumno=a;
            }
        }
        return alumno;
    }

    @PostMapping("/save")
    public Alumno insertAlumno(@RequestBody Alumno alumno) throws Exception{
        if(getAlumnoById(alumno.getId())!=null)
            return alumno;
        alumnos.add(alumno);
        return alumnos.get(alumnos.size()-1);
    }

    @PutMapping("/update/{id}/name/{name}")
    public Alumno updateNombreById(@PathVariable("id") long id, @PathVariable("name") String nombre){
        Alumno alumno=null;
        for(Alumno a: alumnos){
            if(a.getId()==id){
                a.setNombre(nombre);
                alumno=a;
            }
        }
        return alumno;
    }

    @PutMapping("/update")
    public Alumno update(@RequestBody Alumno alumno) throws Exception{
        Alumno al= deleteAlumno(alumno.getId());
        if(al!=null)
            return insertAlumno(alumno);
        else
            return al;
    }


    @DeleteMapping("/delete/{id}")
    public Alumno deleteAlumno(@PathVariable("id") long id) {
        Alumno alumno = getAlumnoById(id);
        alumnos.remove(alumno);
        return alumno;

    }

    @GetMapping("/readFromFile")
    public void read() throws IOException, ClassNotFoundException{
        FileInputStream fin=new FileInputStream("temporal.txt");
        ObjectInputStream ois =new ObjectInputStream(fin);
        alumnos=(ArrayList<Alumno>)ois.readObject();
        fin.close();
    }

    @GetMapping("/saveToFile")
    public void save(){
        try{
            FileOutputStream fout=new FileOutputStream("temporal.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fout);
            oos.writeObject(alumnos);
            fout.close();
        }catch(Exception ex){
            ex.printStackTrace();

        }
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Alumno al){
        for(Alumno a: alumnos) {
            if (a.getId() == al.getId()) {
                break;
            }
        }
        alumnos.add(new Alumno(al.getId(),al.getNombre(),al.getAbout(),al.getCarrera(),al.getDireccion(),al.getEmail()) );
    }

}

