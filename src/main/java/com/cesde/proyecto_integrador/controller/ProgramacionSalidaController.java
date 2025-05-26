package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.ProgramacionSalida;
import com.cesde.proyecto_integrador.repository.ProgramacionSalidaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programaciones-salida")
public class ProgramacionSalidaController {

    private final ProgramacionSalidaRepository programacionSalidaRepository;

    public ProgramacionSalidaController(ProgramacionSalidaRepository programacionSalidaRepository) {
        this.programacionSalidaRepository = programacionSalidaRepository;
    }

    @GetMapping
    public List<ProgramacionSalida> getAllProgramacionesSalida() {
        return programacionSalidaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramacionSalida> getProgramacionSalidaById(@PathVariable Long id) {
        Optional<ProgramacionSalida> programacionSalida = programacionSalidaRepository.findById(id);
        return programacionSalida.map(ResponseEntity::ok)
                                 .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProgramacionSalida createProgramacionSalida(@RequestBody ProgramacionSalida programacionSalida) {
        return programacionSalidaRepository.save(programacionSalida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramacionSalida> updateProgramacionSalida(@PathVariable Long id, @RequestBody ProgramacionSalida programacionSalidaDetails) {
        return programacionSalidaRepository.findById(id)
                .map(programacionSalida -> {
                    programacionSalida.setGrupo(programacionSalidaDetails.getGrupo());
                    programacionSalida.setNumeroEstudiantes(programacionSalidaDetails.getNumeroEstudiantes());
                    programacionSalida.setDia_salida(programacionSalidaDetails.getDia_salida());
                    programacionSalida.setHoraSalida(programacionSalidaDetails.getHoraSalida());
                    programacionSalida.setHoraLlegada(programacionSalidaDetails.getHoraLlegada());
                    programacionSalida.setDestino(programacionSalidaDetails.getDestino());
                    return ResponseEntity.ok(programacionSalidaRepository.save(programacionSalida));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProgramacionSalida(@PathVariable Long id) {
        return programacionSalidaRepository.findById(id)
                .map(programacionSalida -> {
                    programacionSalidaRepository.delete(programacionSalida);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
