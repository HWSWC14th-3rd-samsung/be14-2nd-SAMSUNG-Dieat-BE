package com.samsung.dieat.member.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurity {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests(authz -> authz.requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }
}
