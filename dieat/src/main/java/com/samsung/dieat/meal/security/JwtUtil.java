package com.samsung.dieat.meal.security;//package com.samsung.dieat.meal.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JwtUtil {
//
//    @Value("${token.secret}")
//    private String secretKey;
//
//    private Key key;
//
//    @PostConstruct
//    public void init() {
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//            return true;
//        } catch (SecurityException | MalformedJwtException e) {
//            log.warn("Invalid JWT token");
//        } catch (ExpiredJwtException e) {
//            log.warn("Expired JWT token");
//        } catch (UnsupportedJwtException e) {
//            log.warn("Unsupported JWT token");
//        } catch (IllegalArgumentException e) {
//            log.warn("JWT claims is empty");
//        }
//        return false;
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
//                .parseClaimsJws(token).getBody();
//
//        String userId = claims.getSubject();
//        Integer userCode = claims.get("userCode", Integer.class);
//
//        Collection<SimpleGrantedAuthority> authorities =
//                Arrays.stream(claims.get("auth").toString().replace("[", "").replace("]", "").split(", "))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        CustomUserDetails principal = new CustomUserDetails(userId, "", userCode, authorities);
//
//        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
//    }
//}