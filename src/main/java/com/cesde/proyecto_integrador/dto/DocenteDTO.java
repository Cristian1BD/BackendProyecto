package com.cesde.proyecto_integrador.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DocenteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;

}
