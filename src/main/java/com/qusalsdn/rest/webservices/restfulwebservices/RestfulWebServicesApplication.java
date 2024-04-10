package com.qusalsdn.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000"); // localhost:3000에 대한 크로스 오리진 리퀘스트 처리를 가능하게 변경, 모든 http 메소드 가능하게 변경
            }
        };
    }
}
