package com.qusalsdn.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // 모든 요청이 인증을 받는다.
        http.httpBasic(Customizer.withDefaults()); // 로그인 웹 페이지가 아닌 단순 팝업창으로 인증을 요청하게 한다.
        http.csrf(AbstractHttpConfigurer::disable); // csrf 비활성화
        return http.build();
    }
}
