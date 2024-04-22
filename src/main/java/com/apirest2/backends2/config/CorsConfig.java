package com.apirest2.backends2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/*")
        .allowedOrigins("*") //Escribir la url del proyecto front a conectar
        .allowedMethods("*") //Podemos expecificar los metodos permitidos desde el front, get, post, etc.
        .allowCredentials(true);

    }

}
