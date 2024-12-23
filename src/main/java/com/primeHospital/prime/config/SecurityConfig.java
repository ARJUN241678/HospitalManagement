package com.primeHospital.prime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Enables method-level security like @PreAuthorize
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login").permitAll() // Allow public access
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict access to ADMIN
                        .requestMatchers("/doctor/**").hasRole("DOCTOR") // Restrict access to DOCTOR
                        .requestMatchers("/patient/**").hasRole("PATIENT") // Restrict access to PATIENT
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .httpBasic(httpBasic -> httpBasic.realmName("Hospital Management System")); // Explicit HTTP Basic configuration

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for secure password encoding
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Provide AuthenticationManager bean
    }
}
