package com.gym_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll() // Permitir acceso público
                        .anyRequest().authenticated() // Requiere autenticación para otras rutas
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Página personalizada para login
                        .defaultSuccessUrl("/menu", true) // Redirige al menú tras login exitoso
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login") // Redirige al login tras logout exitoso
                        .permitAll()
                );

        return http.build();
    }
}
