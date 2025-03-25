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
        UserEntity loginUser = userRepository.findByUserId(userId); // 사용자 조회

        if (loginUser == null) {
            throw new UsernameNotFoundException(userId + " 아이디가 존재하지 않습니다.");
        }

        // 사용자 권한을 "ROLE_" 접두어와 함께 SimpleGrantedAuthority로 설정 (권한 정보가 있다면 수정 필요)
        String role = loginUser.getUserRole();  // 예시: 'ROLE_USER' 또는 'ROLE_ADMIN' 형태
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);

        // 사용자 정보를 CustomUserDetails 객체로 반환
        return new CustomUserDetails(
                loginUser.getUserId(),
                loginUser.getUserPwd(),  // 암호화된 비밀번호
                loginUser.getUserCode(),      // 사용자 코드
                role,                         // 사용자 역할
                Collections.singletonList(authority)  // 권한 설정
        );
    }
}