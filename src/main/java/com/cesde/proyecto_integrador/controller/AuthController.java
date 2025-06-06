package com.cesde.proyecto_integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.dto.UserLoginDTO;
import com.cesde.proyecto_integrador.dto.UserLoginResponseDTO;
import com.cesde.proyecto_integrador.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO loginDTO) {
        UserLoginResponseDTO response = authService.login(loginDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + response.getToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(response);
    }
}
