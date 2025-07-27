package com.example.job_portal_system.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            // Public endpoints
            .requestMatchers("/api/users/register", "/api/users/register/employer", "/api/users/login").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/jobs").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/jobs/**").permitAll()

            // Role-based endpoints
            .requestMatchers(HttpMethod.POST, "/api/jobs").hasRole("EMPLOYER")
            .requestMatchers(HttpMethod.DELETE, "/api/jobs/**").hasRole("EMPLOYER")
            .requestMatchers("/api/users/secure").hasRole("USER")
            .requestMatchers("/api/employers/secure").hasRole("EMPLOYER")
            .requestMatchers("/api/admin/secure").hasRole("ADMIN")

            // All others require authentication
            .anyRequest().authenticated()
        )
        .exceptionHandling(ex -> ex
            .authenticationEntryPoint((request, response, authException) ->
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
