package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public void guardarEstudiante(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setTipoDocumento(dto.getTipoDocumento());
        estudiante.setNumeroDocumento(dto.getNumeroDocumento());
        estudiante.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento()));
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setGrupo(dto.getGrupo());
        estudiante.setGenero(dto.getGenero());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setEps(dto.getEps());
        estudiante.setGrupoSanguineo(dto.getGrupoSanguineo());
        estudiante.setInstitucion(dto.getInstitucion());

        estudianteRepository.save(estudiante);
    }
}