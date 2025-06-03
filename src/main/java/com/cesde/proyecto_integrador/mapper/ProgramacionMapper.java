package com.cesde.proyecto_integrador.mapper;

import com.cesde.proyecto_integrador.dto.ProgramacionDTO;
import com.cesde.proyecto_integrador.model.Docente;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.model.Programacion;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ProgramacionMapper {

    public Programacion toEntity(ProgramacionDTO dto) {
        if (dto == null) return null;

        Programacion p = new Programacion();
        p.setId(dto.getId());
        p.setSalida(dto.getSalida());
        p.setAsignacion(dto.getAsignacion());
        p.setOrganizador(dto.getOrganizador());
        p.setFecha(LocalDate.parse(dto.getFecha()));
        p.setHoraSalida(LocalTime.parse(dto.getHoraSalida()));
        p.setHoraRegreso(LocalTime.parse(dto.getHoraRegreso()));
        p.setDestino(dto.getDestino());
        p.setCupo(dto.getCupo());

        if (dto.getGrupoId() != null) {
            Grupo grupo = new Grupo();
            grupo.setId(dto.getGrupoId());
            p.setGrupo(grupo);
        }

        if (dto.getDocenteId() != null) {
            Docente docente = new Docente();
            docente.setId(dto.getDocenteId());
            p.setDocente(docente);
        }

        return p;
    }

    public ProgramacionDTO toDTO(Programacion entity) {
        if (entity == null) return null;

        return ProgramacionDTO.builder()
                .id(entity.getId())
                .salida(entity.getSalida())
                .asignacion(entity.getAsignacion())
                .organizador(entity.getOrganizador())
                .fecha(entity.getFecha().toString())
                .horaSalida(entity.getHoraSalida().toString())
                .horaRegreso(entity.getHoraRegreso().toString())
                .destino(entity.getDestino())
                .cupo(entity.getCupo())
                .grupoId(entity.getGrupo() != null ? entity.getGrupo().getId() : null)
                .docenteId(entity.getDocente() != null ? entity.getDocente().getId() : null)
                .build();
    }
}
