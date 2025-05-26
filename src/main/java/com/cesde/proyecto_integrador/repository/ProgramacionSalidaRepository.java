package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.ProgramacionSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacionSalidaRepository extends JpaRepository<ProgramacionSalida, Long> {
}
