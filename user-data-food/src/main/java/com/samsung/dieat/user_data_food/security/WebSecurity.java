package com.samsung.dieat.user_data_food.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@Configuration
public class WebSecurity {

    private final Environment env;
    private final JwtUtil jwtUtil;

    @Autowired
    public WebSecurity(Environment env, JwtUtil jwtUtil) {
        this.env = env;
        this.jwtUtil = jwtUtil;
    }


    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationProvider dummyProvider = new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                // 단순히 전달받은 Authentication 객체를 반환
                return authentication;
            }
            @Override
            public boolean supports(Class<?> authentication) {
                return true;
            }
        };
        return new ProviderManager(Collections.singletonList(dummyProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(authz ->
                        authz
                                // 예시: /health 엔드포인트는 인증 없이 접근 허용
                                .requestMatchers(new AntPathRequestMatcher("/user-data-food/**", "GET")).permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        // 다운스트림 서비스에서는 로그인 처리 필터(AuthenticationFilter)는 필요 없으므로,
        // JWT 토큰 검증용 JwtFilter만 추가합니다.
        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
