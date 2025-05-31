package com.cesde.proyecto_integrador.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramacionDTO {

    private Long id;
    private String salida;
    private String asignacion;
    private String organizador;
    private LocalDate fecha;
    private LocalTime horaSalida;
    private LocalTime horaRegreso;
    private String destino;
    private Integer cupo;
    private Long grupoId;
    private Long docenteId;

    // Getters y Setters
}
