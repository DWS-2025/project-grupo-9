package com.gym_admin.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/home").permitAll() // Allow public pages
                        .anyRequest().authenticated() // Require authentication for other routes
                )
                .formLogin(login -> login
                        .loginPage("/index") // Must match Mustache file "index.mustache"
                        .defaultSuccessUrl("/home", true) // Redirect after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index") // Redirect after logout
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF (for testing, enable later)

        return http.build();
    }
}