package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "estudiante_formulario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteFormulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formulario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 20)
    private String tipoDocumento; // TI o CC

    @Column(nullable = false, unique = true, length = 20)
    private String numeroDocumento;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 20)
    private String numero;

    @Lob
    @Column(nullable = false)
    private byte[] documentoCargado;

    @Lob
    @Column(nullable = false)
    private byte[] permisoCargado;
}
