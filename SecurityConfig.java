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
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/css/*", "/js/*", "/login", "/home").permitAll() // Permitir acceso sin autenticación
                        .anyRequest().authenticated() // Requerir autenticación para el resto de las páginas
                )
                .formLogin(form -> form
                        .loginPage("/index.html") // Página de login
                        .loginProcessingUrl("/perform_login") // Endpoint para procesar el login
                        .defaultSuccessUrl("/home", true) // Redirigir a /home después de un login exitoso
                        .failureUrl("/index.html?error=true") // Si falla, volver a la página de login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index.html")
                        .permitAll()
                );

        return http.build();
    }
}




/*package com.gym_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/css/*", "/js/*", "/login", "/home").permitAll() // Permitir acceso sin autenticación
                        .anyRequest().authenticated() // Requerir autenticación para el resto de las páginas
                )
                .formLogin(form -> form
                        .loginPage("/index.html") // Página de login
                        .loginProcessingUrl("/perform_login") // Endpoint para procesar el login
                        .defaultSuccessUrl("/home", true) // Redirigir a /home después de un login exitoso
                        .failureUrl("/index.html?error=true") // Si falla, volver a la página de login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index.html")
                        .permitAll()
                );

        return http.build();
    }
}*/