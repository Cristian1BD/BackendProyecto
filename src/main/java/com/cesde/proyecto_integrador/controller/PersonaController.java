package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Persona;
import com.cesde.proyecto_integrador.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Obtener todas las personas
    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    // Obtener una persona por ID
    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Crear una nueva persona
    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            persona.setNombre(personaDetalles.getNombre());
            persona.setApellido(personaDetalles.getApellido());
            persona.setTipo_documento(personaDetalles.getTipo_documento());
            persona.setNumero_documento(personaDetalles.getNumero_documento());
            persona.setFecha_nacimiento(personaDetalles.getFecha_nacimiento());
            persona.setEmail(personaDetalles.getEmail());
            persona.setTelefono(personaDetalles.getTelefono());
            persona.setDireccion(personaDetalles.getDireccion());
            return personaRepository.save(persona);
        }
        return null;
    }

    // Eliminar una persona
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }
}