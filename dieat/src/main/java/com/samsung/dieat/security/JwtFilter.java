package com.samsung.dieat.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Value("${security.jwt.mock-token-enabled:false}")
    private boolean mockTokenEnabled;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        log.info("Authorization Header: {}", authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            if (mockTokenEnabled && "mock-token".equals(token)) {
                log.info("Mock token detected, setting fake authenticated user.");

                CustomUserDetails mockUser = new CustomUserDetails(
                        "mockUser",
                        "mockPassword",
                        1,
                        "ROLE_USER",
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                );

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        mockUser,
                        null,
                        mockUser.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
                return;
            }

            if (jwtUtil.validateToken(token)) {
                Authentication authentication = jwtUtil.getAuthentication(token);
                log.info("JWT 인증 성공: {}", authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                log.warn("JWT 검증 실패: {}", token);
            }
        }

        filterChain.doFilter(request, response);
    }
}