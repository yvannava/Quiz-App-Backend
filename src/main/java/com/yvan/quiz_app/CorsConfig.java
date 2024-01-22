package com.yvan.quiz_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from the specified origin
        config.addAllowedOrigin("http://localhost:5173"); // Replace with your frontend origin

        // Allow relevant HTTP methods (e.g., POST, GET, OPTIONS)
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        // Allow relevant headers (e.g., Content-Type, Authorization)
        config.addAllowedHeader("*");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Accept");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
