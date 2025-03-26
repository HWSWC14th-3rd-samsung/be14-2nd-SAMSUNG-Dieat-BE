package com.samsung.dieat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@Configuration
public class WebSecurity {

    private final Environment env;
    private final JwtUtil jwtUtil;
    private final CommonUserDetailsService commonUserDetailsService;

    @Autowired
    public WebSecurity(Environment env, JwtUtil jwtUtil, CommonUserDetailsService commonUserDetailsService) {
        this.env = env;
        this.jwtUtil = jwtUtil;
        this.commonUserDetailsService = commonUserDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationProvider authProvider = new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                UserDetails userDetails = commonUserDetailsService.loadUserByUsername(authentication.getName());
                return new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return authentication.equals(UsernamePasswordAuthenticationToken.class);
            }
        };
        return new ProviderManager(Collections.singletonList(authProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers(new AntPathRequestMatcher("/user-data-food/**", "GET")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals", "GET")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals", "DELETE")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals/**", "GET")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals/**", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/meals/**", "DELETE")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/diet-posts/**", "GET")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/diet-posts/", "GET")).permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}