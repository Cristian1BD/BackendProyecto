package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.dto.ProgramacionHorarioDTO;
import com.cesde.proyecto_integrador.service.ProgramacionHorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programaciones")
public class ProgramacionHorarioController {

    private final ProgramacionHorarioService programacionService;

    
    public ProgramacionHorarioController(ProgramacionHorarioService programacionService) {
        this.programacionService = programacionService;
    }

    @GetMapping("/horarios")
    public List<ProgramacionHorarioDTO> getHorariosProgramacion() {
        return programacionService.obtenerHorarios();
    }
}
