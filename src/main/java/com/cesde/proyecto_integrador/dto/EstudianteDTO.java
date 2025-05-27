package com.cesde.proyecto_integrador.dto;

import lombok.Data;

@Data
public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento; // ISO-8601
    private String correo;
    private String telefono;
    private String grupo;
    private String genero;
    private String direccion;
    private String eps;
    private String grupoSanguineo;
    private String institucion;
}

