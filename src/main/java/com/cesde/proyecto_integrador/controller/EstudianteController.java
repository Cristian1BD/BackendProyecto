package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "http://localhost:4200") 
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
        return estudianteService.actualizarEstudiante(id, estudianteDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        if (estudianteService.eliminarEstudiante(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}