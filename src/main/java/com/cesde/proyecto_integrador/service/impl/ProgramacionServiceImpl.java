package com.cesde.proyecto_integrador.service.impl;
import com.cesde.proyecto_integrador.dto.ProgramacionDTO;
import com.cesde.proyecto_integrador.model.Programacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.repository.ProgramacionRepository;
import com.cesde.proyecto_integrador.repository.DocenteRepository;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.ProgramacionService;


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
        programacionRepository.save(programacion);
        return mapToDTO(programacion);
    }

    @Override
    public ProgramacionDTO obtenerProgramacion(Long id) {
        Programacion p = programacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrado"));
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
        programacionRepository.deleteById(id);
    }

    @Override
    public ProgramacionDTO actualizarProgramacion(Long id, ProgramacionDTO dto) {
        Programacion p = programacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrado"));
        mapToEntity(dto, p);
        return mapToDTO(programacionRepository.save(p));
    }

    private ProgramacionDTO mapToDTO(Programacion p) {
        ProgramacionDTO dto = new ProgramacionDTO();
        dto.setId(p.getId());
        dto.setSalida(p.getSalida());
        dto.setAsignacion(p.getAsignacion());
        dto.setOrganizador(p.getOrganizador());
        dto.setFecha(p.getFecha());
        dto.setHoraSalida(p.getHoraSalida());
        dto.setHoraRegreso(p.getHoraRegreso());
        dto.setDestino(p.getDestino());
        dto.setCupo(p.getCupo());
        dto.setGrupoId(p.getGrupo() != null ? p.getGrupo().getId() : null);
        dto.setDocenteId(p.getDocente() != null ? p.getDocente().getId() : null);
        return dto;
    }

    private void mapToEntity(ProgramacionDTO dto, Programacion p) {
        p.setSalida(dto.getSalida());
        p.setAsignacion(dto.getAsignacion());
        p.setOrganizador(dto.getOrganizador());
        p.setFecha(dto.getFecha());
        p.setHoraSalida(dto.getHoraSalida());
        p.setHoraRegreso(dto.getHoraRegreso());
        p.setDestino(dto.getDestino());
        p.setCupo(dto.getCupo());
        if (dto.getGrupoId() != null) {
            p.setGrupo(grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado")));
        }
        if (dto.getDocenteId() != null) {
            p.setDocente(docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado")));
        }
    }
}
