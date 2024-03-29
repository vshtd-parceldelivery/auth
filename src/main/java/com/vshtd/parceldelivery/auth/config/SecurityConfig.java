package com.vshtd.parceldelivery.auth.config;


import com.vshtd.parceldelivery.auth.filter.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {
        http
                .securityMatcher("/auth/**")
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, "/auth/jwt/authenticate").permitAll()
                        .requestMatchers(
                                "/auth/v3/api-docs/**",
                                "/auth/swagger-ui/**"
                        ).permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class);

        return http.build();
    }
}

