package com.ghanem.RestfulWebServicesApplication.socialmedia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //		1) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//		2) If a request is not authenticated, a web page is shown
        // http.httpBasic(withDefaults()); // Deprecated in SB 3.1.x
        http.httpBasic(withDefaults()); // Starting from Spring Boot 3.1.x

//		3) CSRF -> POST, PUT
        // http.csrf().disable(); // Deprecated in SB 3.1.x
        http.csrf(csrf -> csrf.disable()); // Starting from Spring Boot 3.1.x
        return  http.build();
    }
}
