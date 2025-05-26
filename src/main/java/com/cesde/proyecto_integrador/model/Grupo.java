package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "grupo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_grupo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private int numeroEstudiantes;
}
