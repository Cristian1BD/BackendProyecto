package com.cesde.proyecto_integrador.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrupoDTO {
    private String nombre;
    private int cupo;
    private String hora;
    private String lugar;
    private String salida;
}