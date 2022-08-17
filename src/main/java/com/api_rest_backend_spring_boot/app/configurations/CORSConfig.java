package com.api_rest_backend_spring_boot.app.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() { return new WebMvcConfigurer() { @Override public void addCorsMappings(CorsRegistry registry) { registry.addMapping("/*").allowedOrigins("").allowedMethods("GET", "POST","PUT", "DELETE"); } }; }


}