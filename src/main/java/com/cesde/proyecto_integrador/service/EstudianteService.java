package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> actualizarEstudiante(Long id, Estudiante estudianteDetails) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setPersona(estudianteDetails.getPersona());
            estudiante.setGrupo(estudianteDetails.getGrupo());
            estudiante.setFecha_registro(estudianteDetails.getFecha_registro());
            return estudianteRepository.save(estudiante);
        });
    }
    

    public boolean eliminarEstudiante(Long id) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudianteRepository.delete(estudiante);
            return true;
        }).orElse(false);
    }
}
