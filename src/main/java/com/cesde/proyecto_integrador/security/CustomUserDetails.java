package com.cesde.proyecto_integrador.security;

import com.cesde.proyecto_integrador.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
            new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // puedes agregar lógica si quieres
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // puedes agregar lógica si quieres
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // puedes agregar lógica si quieres
    }

    @Override
    public boolean isEnabled() {
        return true;  // puedes agregar lógica si quieres
    }
    
    // Método opcional para acceder al User original
    public User getUser() {
        return user;
    }
}
