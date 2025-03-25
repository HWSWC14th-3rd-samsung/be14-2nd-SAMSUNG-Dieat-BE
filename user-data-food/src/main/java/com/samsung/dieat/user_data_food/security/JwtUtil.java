package com.samsung.dieat.user_data_food.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtUtil {

    private final Key key;

    @Autowired
    public JwtUtil(@Value("${token.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty");
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        Integer userCode = (Integer) claims.get("userCode"); // 토큰에서 userCode 추출


        Collection<GrantedAuthority> authorities;
        if (claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다");
        } else {
            authorities = Arrays.stream(claims.get("auth").toString()
                            .replace("[", "")
                            .replace("]", "")
                            .split(", "))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        // JWT 토큰에 담긴 정보만으로 UserDetails 객체를 생성합니다.
        User userDetails = new User(userCode.toString(), "", authorities);
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public Claims parseClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
