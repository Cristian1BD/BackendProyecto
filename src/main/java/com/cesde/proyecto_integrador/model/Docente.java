package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    // Opcional: relación con Programacion (si quieres lista de programaciones)
    @OneToMany(mappedBy = "docente")
    private List<Programacion> programaciones;

    // Getters y Setters
}
