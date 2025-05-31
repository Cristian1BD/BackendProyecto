package com.cesde.proyecto_integrador.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Programacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String salida;
    private String asignacion;
    private String organizador;
    private LocalDate fecha;
    private LocalTime horaSalida;
    private LocalTime horaRegreso;
    private String destino;
    private Integer cupo;

    @ManyToOne
    @JoinColumn(name = "grupo_id") // crea la columna grupo_id en la tabla programacion
    private Grupo grupo;

    @ManyToOne
    private Docente docente;

    // Getters y Setters
}
