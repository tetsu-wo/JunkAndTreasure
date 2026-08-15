package com.example.junkandtreasure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. CORSとCSRFを最もシンプルな設定（デフォルト/無効化）にする
                .cors(org.springframework.security.config.Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)

                // 2. URLごとのアクセス権限を設定する
                .authorizeHttpRequests(authorize -> authorize
                        // OpenAPI / Swagger関連のURLはログインなし（誰でも）アクセスを許可
                        .requestMatchers(
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // それ以外のAPIや画面はすべてログイン（認証）を必須にする
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
