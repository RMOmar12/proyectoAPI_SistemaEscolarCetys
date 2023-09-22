package com.plataformasHeterogeneas.proyectoAPI.service;
import com.plataformasHeterogeneas.proyectoAPI.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    // Implement business logic for schools, e.g., CRUD operations
}
