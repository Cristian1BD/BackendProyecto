package com.cesde.proyecto_integrador.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramacionDTO {
    private Long id;

    private String salida;
    private String asignacion;
    private String organizador;
    private String fecha; // YYYY-MM-DD
    private String horaSalida; // HH:mm
    private String horaRegreso;
    private String destino;
    private Integer cupo;

    private Long grupoId;
    private Long docenteId;
}

