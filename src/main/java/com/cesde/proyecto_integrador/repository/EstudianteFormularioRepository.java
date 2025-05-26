package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteFormularioRepository extends JpaRepository<EstudianteFormulario, Long> {
    Optional<EstudianteFormulario> findByNumeroDocumento(String numeroDocumento);
    Optional<EstudianteFormulario> findByCorreo(String correo);
}
