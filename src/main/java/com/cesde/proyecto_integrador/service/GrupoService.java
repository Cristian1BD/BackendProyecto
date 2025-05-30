package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.dto.GrupoDTO;

import java.util.List;

public interface GrupoService {
    GrupoDTO crearGrupo(GrupoDTO grupoDTO);
    List<GrupoDTO> obtenerTodosLosGrupos();
    GrupoDTO actualizarGrupo(Long id, GrupoDTO grupoDTO);
    void eliminarGrupo(Long id);
}
