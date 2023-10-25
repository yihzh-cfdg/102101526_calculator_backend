package com.yhz.se.config;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST","PUT", "DELETE")
                .allowCredentials(true)
                .exposedHeaders("*")
                .maxAge(3600L);
    }


}
