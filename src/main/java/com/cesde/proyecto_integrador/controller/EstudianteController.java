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
        Map<String, String> response = new HashMap<>();
        try {
            System.out.println(">>> Iniciando registro de estudiante: " + dto.getNumeroDocumento());
            estudianteService.guardarEstudiante(dto);
            response.put("mensaje", "Estudiante registrado correctamente");
            response.put("numeroDocumento", dto.getNumeroDocumento());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(">>> Error en el registro: " + e.getMessage());
            response.put("mensaje", "Error al registrar estudiante: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
