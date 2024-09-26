package com.example.SecureAPI_JWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Disable CSRF protection for all requests
        http.csrf(customizer -> customizer.disable());

        // Disable X-Frame-Options to allow the H2 console frames
        http.headers(headers -> headers.frameOptions().disable());

        // Allow access to H2 console, secure all other endpoints
        http.authorizeHttpRequests(request -> 
                request
                    .requestMatchers("/h2-console/**").permitAll()  // Allow H2 console access
                    .anyRequest().authenticated()  // Secure all other requests
        );

        // Enable basic HTTP authentication
        http.httpBasic(Customizer.withDefaults());

        // Set session management to stateless (for JWT token-based authentication)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}