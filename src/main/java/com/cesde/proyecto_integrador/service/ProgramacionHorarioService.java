package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.dto.ProgramacionHorarioDTO;
import com.cesde.proyecto_integrador.repository.ProgramacionRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProgramacionHorarioService {

    private final ProgramacionRepository programacionRepository;

    public ProgramacionHorarioService(ProgramacionRepository programacionRepository) {
        this.programacionRepository = programacionRepository;
    }

    public List<ProgramacionHorarioDTO> obtenerHorarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return programacionRepository.findAll().stream()
                .filter(programacion -> programacion.getGrupo() != null && programacion.getDocente() != null)
                .map(programacion -> new ProgramacionHorarioDTO(
                        programacion.getId(),
                        programacion.getGrupo().getNombre(),
                        programacion.getHoraSalida().toString(),
                        programacion.getHoraRegreso().toString(),
                        programacion.getDocente().getNombre(),
                        programacion.getFecha().format(formatter)
                ))
                .toList();
    }
}
