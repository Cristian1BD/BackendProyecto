package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.service.EstudianteService;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> registrarEstudiante(@ModelAttribute EstudianteDTO dto) {
        estudianteService.guardarEstudiante(dto);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Estudiante registrado correctamente");
        return ResponseEntity.ok(response);
    }
}