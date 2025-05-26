package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "programacion_salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramacionSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private long grupo;

    @Column(nullable = false)
    private int numeroEstudiantes;

    @Column(nullable = false, length = 255)
    private LocalDateTime dia_salida;

    @Column(nullable = false)
    private LocalTime horaSalida;

    @Column(nullable = false)
    private LocalTime horaLlegada;

    @Column(nullable = false, length = 255)
    private String destino;
}
