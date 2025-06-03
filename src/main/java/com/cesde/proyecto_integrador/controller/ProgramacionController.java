package com.cesde.proyecto_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.dto.ProgramacionDTO;
import com.cesde.proyecto_integrador.service.ProgramacionService;

@RestController
@RequestMapping("/api/programaciones")
public class ProgramacionController {

    @Autowired
    private ProgramacionService programacionService;

    @PostMapping
    public ResponseEntity<ProgramacionDTO> crear(@RequestBody ProgramacionDTO dto) {
        return ResponseEntity.ok(programacionService.crearProgramacion(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramacionDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(programacionService.obtenerProgramacion(id));
    }

    @GetMapping
    public ResponseEntity<List<ProgramacionDTO>> listar() {
        return ResponseEntity.ok(programacionService.listarProgramaciones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramacionDTO> actualizar(@PathVariable Long id, @RequestBody ProgramacionDTO dto) {
        return ResponseEntity.ok(programacionService.actualizarProgramacion(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        programacionService.eliminarProgramacion(id);
        return ResponseEntity.noContent().build();
    }
}
