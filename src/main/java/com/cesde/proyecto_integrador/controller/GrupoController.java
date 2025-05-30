package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.GrupoDTO;
import com.cesde.proyecto_integrador.service.GrupoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "*") // Cambia esto por el dominio de tu frontend para más seguridad
public class GrupoController {

    private final GrupoService grupoService;

    // Inyección vía constructor (mejor práctica)
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    /**
     * Crea un nuevo grupo.
     */
    @PostMapping
    public ResponseEntity<GrupoDTO> crearGrupo(@RequestBody GrupoDTO grupoDTO) {
        GrupoDTO nuevoGrupo = grupoService.crearGrupo(grupoDTO);
        return ResponseEntity.ok(nuevoGrupo);
    }

    /**
     * Obtiene todos los grupos.
     */
    @GetMapping
    public ResponseEntity<List<GrupoDTO>> obtenerGrupos() {
        List<GrupoDTO> grupos = grupoService.obtenerTodosLosGrupos();
        return ResponseEntity.ok(grupos);
    }

    /**
     * Actualiza un grupo existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> actualizarGrupo(@PathVariable Long id, @RequestBody GrupoDTO grupoDTO) {
        GrupoDTO grupoActualizado = grupoService.actualizarGrupo(id, grupoDTO);
        return ResponseEntity.ok(grupoActualizado);
    }

    /**
     * Elimina un grupo por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        grupoService.eliminarGrupo(id);
        return ResponseEntity.noContent().build();
    }
}