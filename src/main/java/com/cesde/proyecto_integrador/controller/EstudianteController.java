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
        System.out.println(">>> Entrando a registrarEstudiante()");
        System.out.println("DTO recibido: " + dto);

        try {
            estudianteService.guardarEstudiante(dto);
            System.out.println(">>> Estudiante guardado");

            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Estudiante registrado correctamente");
            response.put("numeroDocumento", dto.getNumeroDocumento());
            System.out.println(">>> Respuesta generada");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error al registrar estudiante: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }
}