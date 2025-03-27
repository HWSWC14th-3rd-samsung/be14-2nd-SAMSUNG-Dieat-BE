package com.samsung.dieat.security;

import com.samsung.dieat.member.command.domain.repository.UserRepository;
import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CommonUserDetailsService {

    private final UserRepository userRepository;

    // username (아이디)로 사용자 정보를 불러오는 메서드
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity loginUser = userRepository.findByUserId(userId);

        if (loginUser == null) {
            throw new UsernameNotFoundException(userId + " 아이디가 존재하지 않습니다.");
        }

        String role = loginUser.getUserRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);

        return new CustomUserDetails(
                loginUser.getUserId(),
                loginUser.getUserPwd(),
                loginUser.getUserCode(),
                role,
                Collections.singletonList(authority)
        );
    }
}