package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.GrupoDTO;
import com.cesde.proyecto_integrador.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "*")  // En producción, restringe a tu frontend
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> crearGrupo(@RequestBody GrupoDTO grupoDTO) {
        GrupoDTO nuevoGrupo = grupoService.crearGrupo(grupoDTO);
        return ResponseEntity.ok(nuevoGrupo);
    }

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> obtenerGrupos() {
        List<GrupoDTO> grupos = grupoService.obtenerTodosLosGrupos();
        return ResponseEntity.ok(grupos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> actualizarGrupo(@PathVariable Long id, @RequestBody GrupoDTO grupoDTO) {
        GrupoDTO grupoActualizado = grupoService.actualizarGrupo(id, grupoDTO);
        return ResponseEntity.ok(grupoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        grupoService.eliminarGrupo(id);
        return ResponseEntity.noContent().build();
    }
}
