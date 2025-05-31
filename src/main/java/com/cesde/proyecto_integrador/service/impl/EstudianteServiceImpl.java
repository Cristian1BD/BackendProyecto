package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.repository.EstudianteRepository;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private GrupoRepository grupoRepository;

    private final String uploadDir = "/tmp/uploads/";

    @Override
    public void guardarEstudiante(EstudianteDTO dto) {
        System.out.println("========== [LOG SERVICE] ==========");
        System.out.println("Iniciando guardado de estudiante en base de datos...");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setTipoDocumento(dto.getTipoDocumento());
        estudiante.setNumeroDocumento(dto.getNumeroDocumento());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setGenero(dto.getGenero());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setEps(dto.getEps());
        estudiante.setGrupoSanguineo(dto.getGrupoSanguineo());
        estudiante.setInstitucion(dto.getInstitucion());

        if (dto.getGrupoId() != null) {
            Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
            estudiante.setGrupo(grupo);
        }

        try {
            System.out.println(">>> Guardando archivos...");
            estudiante.setDocumentoIdentidadPath(saveFile(dto.getDocumentoIdentidad()));
            estudiante.setPermisoMenorPath(saveFile(dto.getPermisoMenor()));
            System.out.println(">>> Archivos guardados correctamente.");
        } catch (IOException e) {
            System.out.println(">>> Error al guardar archivos: " + e.getMessage());
            throw new RuntimeException("Error al guardar archivos", e);
        }

        repository.save(estudiante);
        System.out.println(">>> Estudiante guardado exitosamente en base de datos.");
    }

    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            System.out.println(">>> Archivo no recibido o vacío.");
            return null;
        }

        String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(">>> Archivo guardado en: " + filePath);
        return filePath;
    }

    @Override
    public List<EstudianteDTO> obtenerTodos() {
        List<Estudiante> estudiantes = repository.findAll();
        return estudiantes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setNumeroDocumento(estudiante.getNumeroDocumento());
        return dto;
    }

    @Override
    public void asignarGrupo(Long estudianteId, Long grupoId) {
        Estudiante estudiante = repository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        estudiante.setGrupo(grupo);
        repository.save(estudiante);
    }

    // ✅ Método para eliminar estudiante
    @Override
    public void eliminarEstudiante(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        repository.deleteById(id);
        System.out.println(">>> Estudiante con ID " + id + " eliminado correctamente.");
    }
}
