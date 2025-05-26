package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir peticiones desde Angular
public class GrupoController {

    private final GrupoRepository grupoRepository;

    public GrupoController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @GetMapping
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Long id_grupo) {
        Optional<Grupo> grupo = grupoRepository.findById(id_grupo);
        return grupo.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Grupo createGrupo(@RequestBody Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Long id_grupo, @RequestBody Grupo grupoDetails) {
        return grupoRepository.findById(id_grupo)
                .map(grupo -> {
                    grupo.setNombre(grupoDetails.getNombre());
                    grupo.setDescripcion(grupoDetails.getDescripcion());
                    grupo.setNumeroEstudiantes(grupoDetails.getNumeroEstudiantes());
                    return ResponseEntity.ok(grupoRepository.save(grupo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGrupo(@PathVariable Long id_grupo) {
        return grupoRepository.findById(id_grupo)
                .map(grupo -> {
                    grupoRepository.delete(grupo);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
