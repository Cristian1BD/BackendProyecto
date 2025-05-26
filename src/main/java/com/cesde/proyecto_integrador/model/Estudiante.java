package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupo;

    private LocalDateTime fecha_registro;

    // Getters y Setters
    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
