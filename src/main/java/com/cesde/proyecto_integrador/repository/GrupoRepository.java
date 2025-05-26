package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
