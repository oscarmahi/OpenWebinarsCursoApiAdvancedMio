package com.openwebinars.rest.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               // registry.addMapping("/**");       //esta linea unicamente valdría para dar acceso a todo
                registry.addMapping("/product/**")
                        .allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT","DELETE")
                        .maxAge(3600);      //esto es para restringir el tamaño de la cache
            }
        };
    }

}
