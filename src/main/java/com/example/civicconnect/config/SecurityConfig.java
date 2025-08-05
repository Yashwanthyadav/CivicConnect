package com.example.civicconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder; // Import PasswordEncoder
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disables CSRF protection for simplicity (be cautious in production)
            .authorizeHttpRequests()
            .anyRequest().permitAll(); // Allows all requests without authentication for now
        return http.build();
    }

    // Define the PasswordEncoder bean here
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Using BCryptPasswordEncoder, a strong and widely recommended password encoder
        return new BCryptPasswordEncoder();
    }
}
