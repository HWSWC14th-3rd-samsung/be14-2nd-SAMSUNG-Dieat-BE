package com.samsung.dieat.member.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsung.dieat.member.command.domain.aggregate.vo.RequestLoginVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            RequestLoginVO creds = new ObjectMapper().readValue(request.getInputStream(), RequestLoginVO.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getUserId(), creds.getUserPwd(), new ArrayList<>())
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
