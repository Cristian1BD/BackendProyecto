package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.ProgramacionDTO;
import com.cesde.proyecto_integrador.model.Docente;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.model.Programacion;
import com.cesde.proyecto_integrador.repository.DocenteRepository;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.repository.ProgramacionRepository;
import com.cesde.proyecto_integrador.service.ProgramacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramacionServiceImpl implements ProgramacionService {

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public ProgramacionDTO crearProgramacion(ProgramacionDTO dto) {
        Programacion programacion = new Programacion();
        mapToEntity(dto, programacion);
        programacion = programacionRepository.save(programacion);
        return mapToDTO(programacion);
    }

    @Override
    public ProgramacionDTO obtenerProgramacion(Long id) {
        Programacion p = programacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Programación no encontrada con ID: " + id));
        return mapToDTO(p);
    }

    @Override
    public List<ProgramacionDTO> listarProgramaciones() {
        return programacionRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminarProgramacion(Long id) {
        if (!programacionRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: Programación no encontrada");
        }
        programacionRepository.deleteById(id);
    }

    @Override
    public ProgramacionDTO actualizarProgramacion(Long id, ProgramacionDTO dto) {
        Programacion p = programacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Programación no encontrada con ID: " + id));
        mapToEntity(dto, p);
        return mapToDTO(programacionRepository.save(p));
    }

    // Mapear de Entity a DTO
    private ProgramacionDTO mapToDTO(Programacion p) {
        return ProgramacionDTO.builder()
            .id(p.getId())
            .salida(p.getSalida())
            .asignacion(p.getAsignacion())
            .organizador(p.getOrganizador())
            .fecha(p.getFecha().toString())  // LocalDate a String
            .horaSalida(p.getHoraSalida().toString()) // LocalTime a String
            .horaRegreso(p.getHoraRegreso().toString())
            .destino(p.getDestino())
            .cupo(p.getCupo())
            .grupoId(p.getGrupo() != null ? p.getGrupo().getId() : null)
            .docenteId(p.getDocente() != null ? p.getDocente().getId() : null)
            .build();
    }

    // Mapear de DTO a Entity
    private void mapToEntity(ProgramacionDTO dto, Programacion p) {
        p.setSalida(dto.getSalida());
        p.setAsignacion(dto.getAsignacion());
        p.setOrganizador(dto.getOrganizador());
        p.setFecha(LocalDate.parse(dto.getFecha()));
        p.setHoraSalida(LocalTime.parse(dto.getHoraSalida()));
        p.setHoraRegreso(LocalTime.parse(dto.getHoraRegreso()));
        p.setDestino(dto.getDestino());
        p.setCupo(dto.getCupo());

        if (dto.getGrupoId() != null) {
            Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con ID: " + dto.getGrupoId()));
            p.setGrupo(grupo);
        }

        if (dto.getDocenteId() != null) {
            Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado con ID: " + dto.getDocenteId()));
            p.setDocente(docente);
        }
    }
}
