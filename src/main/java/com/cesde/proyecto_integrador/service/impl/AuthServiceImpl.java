package com.cesde.proyecto_integrador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.dto.UserLoginDTO;
import com.cesde.proyecto_integrador.dto.UserLoginResponseDTO;
import com.cesde.proyecto_integrador.exception.AuthenticationException;
import com.cesde.proyecto_integrador.model.User;
import com.cesde.proyecto_integrador.repository.UserRepository;
import com.cesde.proyecto_integrador.security.JwtUtil;
import com.cesde.proyecto_integrador.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserLoginResponseDTO login(UserLoginDTO loginDTO) {
        User userLogin = userRepository.findByEmail(loginDTO.getEmail());
        if (userLogin == null) {
            throw new AuthenticationException("Email not found");
        }
        if (!passwordEncoder.matches(loginDTO.getPassword(), userLogin.getPassword())) {
            throw new AuthenticationException("Invalid password");
        }

        String token = jwtUtil.generateToken(userLogin.getEmail(), userLogin.getRole().toString());

        return new UserLoginResponseDTO(
            userLogin.getEmail(),
            userLogin.getRole().toString(),
            token
        );
    }
}
