package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.service.EstudianteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> listarEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodos();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> registrarEstudiante(@ModelAttribute EstudianteDTO dto) {
        Map<String, String> response = new HashMap<>();
        try {
            System.out.println("========== [LOG CONTROLLER] ==========");
            System.out.println("Iniciando registro de estudiante...");
            System.out.println("Nombre: " + dto.getNombre());
            System.out.println("Apellido: " + dto.getApellido());
            System.out.println("Tipo Documento: " + dto.getTipoDocumento());
            System.out.println("Número Documento: " + dto.getNumeroDocumento());
            System.out.println("Correo: " + dto.getCorreo());
            System.out.println("Teléfono: " + dto.getTelefono());
            System.out.println("Documento Identidad: "
                    + (dto.getDocumentoIdentidad() != null ? dto.getDocumentoIdentidad().getOriginalFilename()
                            : "null"));
            System.out.println("Permiso Menor: "
                    + (dto.getPermisoMenor() != null ? dto.getPermisoMenor().getOriginalFilename() : "null"));

            estudianteService.guardarEstudiante(dto);

            response.put("mensaje", "Estudiante registrado correctamente");
            response.put("numeroDocumento", dto.getNumeroDocumento());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(">>> Error en el registro: " + e.getMessage());
            response.put("mensaje", "Error al registrar estudiante: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/{id}/grupo/{grupoId}")
    public ResponseEntity<?> asignarGrupo(@PathVariable Long id, @PathVariable Long grupoId) {
        try {
            estudianteService.asignarGrupo(id, grupoId);
            return ResponseEntity.ok().body(Map.of("mensaje", "Grupo asignado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("mensaje", e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        try {
            estudianteService.eliminarEstudiante(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
    }
}
// End of EstudianteController.java