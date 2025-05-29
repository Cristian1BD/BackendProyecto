package com.cesde.proyecto_integrador.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String correo;
    private String telefono;
    private String grupo;
    private String genero;
    private String direccion;
    private String eps;
    private String grupoSanguineo;
    private String institucion;

    private String documentoIdentidadPath;
    private String permisoMenorPath;
}