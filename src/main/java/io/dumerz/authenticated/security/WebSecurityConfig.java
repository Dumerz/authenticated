package io.dumerz.authenticated.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests( auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                .anyRequest().authenticated())
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**") // Disable CSRF for H2 console
            )
            .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Allow the H2 console to be displayed in a frame
        );
        return http.build();
    }
}
