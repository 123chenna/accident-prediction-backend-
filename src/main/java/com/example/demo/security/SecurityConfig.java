package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter filter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // ✅ correct syntax
            .cors(cors -> {})               // ✅ enable CORS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/api/**").permitAll()   // 🔥 allow predict
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable())     // ✅ important
            .httpBasic(basic -> basic.disable());  // ✅ important

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class); // 🔥 REQUIRED

        return http.build();
    }
}
