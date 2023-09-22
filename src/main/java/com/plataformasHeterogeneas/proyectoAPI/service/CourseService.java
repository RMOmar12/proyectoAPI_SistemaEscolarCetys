package com.plataformasHeterogeneas.proyectoAPI.service;

import com.plataformasHeterogeneas.proyectoAPI.model.Course;
import com.plataformasHeterogeneas.proyectoAPI.repository.CourseRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Implement CRUD operations or custom business logic for courses

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setCourseID(id);
            return courseRepository.save(course);
        }
        return null; // Course not found
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
