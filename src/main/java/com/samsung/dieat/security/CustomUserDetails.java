
package com.samsung.dieat.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Integer userCode;  // Integer로 수정
    private String role;
    private Collection<? extends GrantedAuthority> authorities;

    // 수정된 생성자
    public CustomUserDetails(String username, String password, Integer userCode, String role, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.userCode = userCode;
        this.role = role;
        this.authorities = authorities;
    }

    // 나머지 메소드들
}