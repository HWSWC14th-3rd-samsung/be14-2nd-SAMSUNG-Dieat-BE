package com.samsung.dieat.user_data_food.command.application.service;

import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodRequest;
import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import com.samsung.dieat.user_data_food.command.infrastructure.UserDataFoodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserDataFoodService {

    private final ModelMapper modelMapper;
    private final UserDataFoodRepository userDataFoodRepository;

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

    public UserDetails loadUserByUsername(String userId) {
        return null;
    }
}
