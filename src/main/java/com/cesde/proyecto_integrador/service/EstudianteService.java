package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
public interface EstudianteService {
    void guardarEstudiante(EstudianteDTO dto);
    List<EstudianteDTO> obtenerTodos();
}