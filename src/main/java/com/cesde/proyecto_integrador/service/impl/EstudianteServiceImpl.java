package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.EstudianteDTO;
import com.cesde.proyecto_integrador.service.EstudianteService;
import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    private final String uploadDir = "uploads/";

    @Override
    public void guardarEstudiante(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setTipoDocumento(dto.getTipoDocumento());
        estudiante.setNumeroDocumento(dto.getNumeroDocumento());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setGrupo(dto.getGrupo());
        estudiante.setGenero(dto.getGenero());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setEps(dto.getEps());
        estudiante.setGrupoSanguineo(dto.getGrupoSanguineo());
        estudiante.setInstitucion(dto.getInstitucion());

        try {
            estudiante.setDocumentoIdentidadPath(saveFile(dto.getDocumentoIdentidad()));
            estudiante.setPermisoMenorPath(saveFile(dto.getPermisoMenor()));
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar archivos", e);
        }

        repository.save(estudiante);
    }

    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;

        String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }
}