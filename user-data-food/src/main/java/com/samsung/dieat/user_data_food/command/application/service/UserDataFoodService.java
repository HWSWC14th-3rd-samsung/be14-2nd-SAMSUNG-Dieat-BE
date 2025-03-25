package com.samsung.dieat.user_data_food.command.application.service;

import com.samsung.dieat.user_data_food.command.domain.repository.UserRepository;
import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import com.samsung.dieat.user_data_food.command.entity.UserEntity;
import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodRequest;
import com.samsung.dieat.user_data_food.command.infrastructure.UserDataFoodRepository;
import com.samsung.dieat.user_data_food.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserDataFoodService {

    private final ModelMapper modelMapper;
    private final UserDataFoodRepository userDataFoodRepository;
    private final UserRepository userRepository;


    @Transactional
    public UserDataFood saveUserDataFood(InsertUserDataFoodRequest request) {
        UserDataFood userDataFood = InsertUserDataFoodRequest.toEntity(request);
        return userDataFoodRepository.save(userDataFood);
    }

    @Transactional
    public void deleteUserDataFood(Integer udfCode) {
        UserDataFood userDataFood = userDataFoodRepository.findById(udfCode).orElseThrow();
        userDataFoodRepository.delete(userDataFood);
    }

    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity tokenUser = userRepository.findByUserId(userId);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if("ADMIN".equals(tokenUser.getRole())) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return new CustomUserDetails(
                tokenUser.getUserId(),
                tokenUser.getEncryptedPwd(),
                tokenUser.getUserCode(),
                grantedAuthorities
        );
    }
}
