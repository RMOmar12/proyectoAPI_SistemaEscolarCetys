package com.plataformasHeterogeneas.proyectoAPI.controller;

import com.plataformasHeterogeneas.proyectoAPI.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    // Implement REST endpoints for schools, e.g., create, read, update, delete
}