package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.GrupoDTO;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.GrupoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public GrupoDTO crearGrupo(GrupoDTO dto) {
        Grupo grupo = Grupo.builder()
                .nombre(dto.getNombre())
                .cupo(dto.getCupo())
                .hora(dto.getHora())
                .lugar(dto.getLugar())
                .salida(dto.getSalida())
                .build();

        Grupo guardado = grupoRepository.save(grupo);

        return mapToDTO(guardado);
    }

    @Override
    public List<GrupoDTO> obtenerTodosLosGrupos() {
        return grupoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoDTO actualizarGrupo(Long id, GrupoDTO dto) {
        Optional<Grupo> optionalGrupo = grupoRepository.findById(id);
        if (optionalGrupo.isEmpty()) {
            throw new RuntimeException("Grupo no encontrado con ID: " + id);
        }

        Grupo grupo = optionalGrupo.get();
        grupo.setNombre(dto.getNombre());
        grupo.setCupo(dto.getCupo());
        grupo.setHora(dto.getHora());
        grupo.setLugar(dto.getLugar());
        grupo.setSalida(dto.getSalida());

        Grupo actualizado = grupoRepository.save(grupo);
        return mapToDTO(actualizado);
    }

    @Override
    public void eliminarGrupo(Long id) {
        if (!grupoRepository.existsById(id)) {
            throw new RuntimeException("Grupo no encontrado con ID: " + id);
        }
        grupoRepository.deleteById(id);
    }

    // Método utilitario para mapear de Entidad a DTO
    private GrupoDTO mapToDTO(Grupo grupo) {
        return GrupoDTO.builder()
                .nombre(grupo.getNombre())
                .cupo(grupo.getCupo())
                .hora(grupo.getHora())
                .lugar(grupo.getLugar())
                .salida(grupo.getSalida())
                .build();
    }
}
