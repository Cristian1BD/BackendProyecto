package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.GrupoDTO;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.GrupoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public GrupoDTO crearGrupo(GrupoDTO dto) {
        Grupo grupo = mapToEntity(dto);
        grupo = grupoRepository.save(grupo);
        return mapToDTO(grupo);
    }

    @Override
    public List<GrupoDTO> obtenerTodosLosGrupos() {
        return grupoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoDTO actualizarGrupo(Long id, GrupoDTO dto) {
        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con ID: " + id));
        grupo.setNombre(dto.getNombre());
        grupo.setCupo(dto.getCupo());
        grupo.setHora(dto.getHora());
        grupo.setLugar(dto.getLugar());
        grupo.setSalida(dto.getSalida());
        return mapToDTO(grupoRepository.save(grupo));
    }

    @Override
    public void eliminarGrupo(Long id) {
        grupoRepository.deleteById(id);
    }

    // Utilidades de mapeo
    private GrupoDTO mapToDTO(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO();
        dto.setId(grupo.getId());
        dto.setNombre(grupo.getNombre());
        dto.setCupo(grupo.getCupo());
        dto.setHora(grupo.getHora());
        dto.setLugar(grupo.getLugar());
        dto.setSalida(grupo.getSalida());
        return dto;
    }

    private Grupo mapToEntity(GrupoDTO dto) {
        Grupo grupo = new Grupo();
        grupo.setId(dto.getId());
        grupo.setNombre(dto.getNombre());
        grupo.setCupo(dto.getCupo());
        grupo.setHora(dto.getHora());
        grupo.setLugar(dto.getLugar());
        grupo.setSalida(dto.getSalida());
        return grupo;
    }
}
