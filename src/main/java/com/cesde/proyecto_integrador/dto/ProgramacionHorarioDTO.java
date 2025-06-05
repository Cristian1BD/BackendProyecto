package com.cesde.proyecto_integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgramacionHorarioDTO {
    private Long id;
    private String nombreGrupo;
    private String horaSalida;
    private String horaRegreso;
    private String docente;
    private String fecha;
}
