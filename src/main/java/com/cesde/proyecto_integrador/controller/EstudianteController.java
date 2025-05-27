package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*") // o especifica origenes si usas credentials
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<String> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.guardarEstudiante(estudianteDTO);
        return ResponseEntity.ok("Estudiante registrado correctamente.");
    }

    // Obtener todos los estudiantes (GET)
    @GetMapping
    public ResponseEntity<String> obtenerEstudiantes() {
        return ResponseEntity.ok("GET: Lista de estudiantes (dummy)");
    }

    // Actualizar un estudiante (PUT)
    @PutMapping
    public ResponseEntity<String> actualizarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return ResponseEntity.ok("PUT: Estudiante actualizado (dummy)");
    }

    // Eliminar un estudiante (DELETE)
    @DeleteMapping
    public ResponseEntity<String> eliminarEstudiante(@RequestParam Long id) {
        return ResponseEntity.ok("DELETE: Estudiante eliminado (dummy)");
    }

    // Preflight (OPTIONS)
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options() {
        return ResponseEntity.ok().build();
    }
}
