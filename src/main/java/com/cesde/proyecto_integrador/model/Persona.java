package com.cesde.proyecto_integrador.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "persona")
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String tipo_documento;
    private long numero_documento;
    private LocalDate fecha_nacimiento;
    private String email;
    private String telefono;
    private String direccion;

    // Getters y Setters
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    public long getNumero_documento() {
        return numero_documento;
    }
    public void setNumero_documento(long numero_documento) {
        this.numero_documento = numero_documento;
    }
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
