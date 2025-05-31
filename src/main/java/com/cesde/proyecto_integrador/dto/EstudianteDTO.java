package com.cesde.proyecto_integrador.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String correo;
    private String telefono;
    private Long grupoId;
    private String genero;
    private String direccion;
    private String eps;
    private String grupoSanguineo;
    private String institucion;

    // Archivos adjuntos
    private MultipartFile documentoIdentidad;
    private MultipartFile permisoMenor;
}