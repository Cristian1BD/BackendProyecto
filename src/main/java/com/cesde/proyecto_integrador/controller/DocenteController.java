package com.cesde.proyecto_integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.dto.DocenteDTO;
import com.cesde.proyecto_integrador.service.DocenteService;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public ResponseEntity<DocenteDTO> crear(@RequestBody DocenteDTO dto) {
        return ResponseEntity.ok(docenteService.crearDocente(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(docenteService.obtenerDocente(id));
    }

    @GetMapping
    public ResponseEntity<List<DocenteDTO>> listar() {
        return ResponseEntity.ok(docenteService.listarDocentes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> actualizar(@PathVariable Long id, @RequestBody DocenteDTO dto) {
        return ResponseEntity.ok(docenteService.actualizarDocente(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        docenteService.eliminarDocente(id);
        return ResponseEntity.noContent().build();
    }
}
