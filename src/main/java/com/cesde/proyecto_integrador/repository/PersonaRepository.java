package com.cesde.proyecto_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cesde.proyecto_integrador.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Métodos personalizados si los necesitas
}