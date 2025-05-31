package com.cesde.proyecto_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesde.proyecto_integrador.model.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}