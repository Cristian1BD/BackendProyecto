package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.EstudianteFormulario;
import com.cesde.proyecto_integrador.repository.EstudianteFormularioRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantesFormulario")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteFormularioController {

    private final EstudianteFormularioRepository repository;

    public EstudianteFormularioController(EstudianteFormularioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EstudianteFormulario> getAllEstudiantes() {
        return repository.findAll();
    }

    @GetMapping("/{id_formulario}")
    public ResponseEntity<EstudianteFormulario> getEstudianteById(@PathVariable Long id_formulario) {
        return repository.findById(id_formulario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstudianteFormulario> createEstudiante(@RequestBody @Valid EstudianteFormulario estudiante) {
        EstudianteFormulario savedEstudiante = repository.save(estudiante);
        return ResponseEntity.status(201).body(savedEstudiante);
    }

    @PutMapping("/{id_formulario}")
    public ResponseEntity<EstudianteFormulario> updateEstudiante(@PathVariable Long id_formulario, @RequestBody @Valid EstudianteFormulario estudianteDetails) {
        return repository.findById(id_formulario).map(estudiante -> {
            estudiante.setNombre(estudianteDetails.getNombre());
            estudiante.setApellido(estudianteDetails.getApellido());
            estudiante.setTipoDocumento(estudianteDetails.getTipoDocumento());
            estudiante.setNumeroDocumento(estudianteDetails.getNumeroDocumento());
            estudiante.setCorreo(estudianteDetails.getCorreo());
            estudiante.setNumero(estudianteDetails.getNumero());
            estudiante.setDocumentoCargado(estudianteDetails.getDocumentoCargado());
            estudiante.setPermisoCargado(estudianteDetails.getPermisoCargado());
            EstudianteFormulario updatedEstudiante = repository.save(estudiante);
            return ResponseEntity.ok(updatedEstudiante);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_formulario}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id_formulario) {
        Optional<EstudianteFormulario> estudianteOpt = repository.findById(id_formulario);
        if (estudianteOpt.isPresent()) {
            repository.delete(estudianteOpt.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
