package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
