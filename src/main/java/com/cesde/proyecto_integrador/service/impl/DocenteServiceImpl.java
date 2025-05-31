package com.cesde.proyecto_integrador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.dto.DocenteDTO;
import com.cesde.proyecto_integrador.model.Docente;
import com.cesde.proyecto_integrador.repository.DocenteRepository;
import com.cesde.proyecto_integrador.service.DocenteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public DocenteDTO crearDocente(DocenteDTO dto) {
        Docente docente = mapToEntity(dto);
        docenteRepository.save(docente);
        return mapToDTO(docente);
    }

    @Override
    public DocenteDTO obtenerDocente(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        return mapToDTO(docente);
    }

    @Override
    public List<DocenteDTO> listarDocentes() {
        return docenteRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocenteDTO actualizarDocente(Long id, DocenteDTO dto) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setEmail(dto.getEmail());
        return mapToDTO(docenteRepository.save(docente));
    }

    @Override
    public void eliminarDocente(Long id) {
        docenteRepository.deleteById(id);
    }

    private DocenteDTO mapToDTO(Docente d) {
        DocenteDTO dto = new DocenteDTO();
        dto.setId(d.getId());
        dto.setNombre(d.getNombre());
        dto.setApellido(d.getApellido());
        dto.setEmail(d.getEmail());
        return dto;
    }

    private Docente mapToEntity(DocenteDTO dto) {
        Docente d = new Docente();
        d.setNombre(dto.getNombre());
        d.setApellido(dto.getApellido());
        d.setEmail(dto.getEmail());
        return d;
    }
}
