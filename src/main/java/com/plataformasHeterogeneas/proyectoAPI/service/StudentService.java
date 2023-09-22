package com.plataformasHeterogeneas.proyectoAPI.service;

import com.plataformasHeterogeneas.proyectoAPI.model.Student;
import com.plataformasHeterogeneas.proyectoAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {

        return student;
    }

    public List<Student> getAllStudents() {
        return null;
    }

    public Student getStudentById(Long id) {
        return null;
    }

    public Student updateStudent(Long id, Student student) {
        return student;
    }

    public void deleteStudent(Long id) {
    }

    // Implement CRUD operations and business logic
}