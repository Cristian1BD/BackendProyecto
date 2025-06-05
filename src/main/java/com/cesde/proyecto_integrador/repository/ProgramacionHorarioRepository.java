package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacionHorarioRepository extends JpaRepository<Programacion, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas después
}