package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.dto.UserLoginDTO;
import com.cesde.proyecto_integrador.dto.UserLoginResponseDTO;

public interface AuthService {
    UserLoginResponseDTO login(UserLoginDTO loginDTO);
}
