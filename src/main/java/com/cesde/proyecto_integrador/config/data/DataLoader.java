package com.cesde.proyecto_integrador.config.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cesde.proyecto_integrador.model.User;
import com.cesde.proyecto_integrador.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("Cristian@estudiante.com") == null) {
            User adminUser = new User();           
            adminUser.setEmail("Cristian@estudiante.com");
            adminUser.setPassword(passwordEncoder.encode("estudiante"));
            adminUser.setRole(User.Role.STUDENT);
            userRepository.save(adminUser);
        }       
    }
}
