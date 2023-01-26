package com.flow.oauth.config;

import com.flow.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuthService oAuthService;
    private final CustomOAuthSuccessHandler customOAuthSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()

                .logout()
                .logoutSuccessUrl("/")
                .and()

                .oauth2Login()
                .loginPage("/oauth/login")
                .failureUrl("/oauth/login")
                .successHandler(customOAuthSuccessHandler)
                .userInfoEndpoint()
                .userService(oAuthService);

        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/");

        return http.build();
    }
}
