package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.dto.DocenteDTO;

public interface DocenteService {
    DocenteDTO crearDocente(DocenteDTO dto);
    DocenteDTO obtenerDocente(Long id);
    List<DocenteDTO> listarDocentes();
    DocenteDTO actualizarDocente(Long id, DocenteDTO dto);
    void eliminarDocente(Long id);
}
