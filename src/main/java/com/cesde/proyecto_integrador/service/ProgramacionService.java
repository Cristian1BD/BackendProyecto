package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.dto.ProgramacionDTO;

public interface ProgramacionService {
    ProgramacionDTO crearProgramacion(ProgramacionDTO dto);
    ProgramacionDTO obtenerProgramacion(Long id);
    List<ProgramacionDTO> listarProgramaciones();
    void eliminarProgramacion(Long id);
    ProgramacionDTO actualizarProgramacion(Long id, ProgramacionDTO dto);
}