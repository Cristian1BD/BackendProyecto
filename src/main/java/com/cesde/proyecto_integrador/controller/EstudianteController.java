package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<String> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.guardarEstudiante(estudianteDTO);
        return ResponseEntity.ok("Estudiante registrado correctamente.");
    }
}