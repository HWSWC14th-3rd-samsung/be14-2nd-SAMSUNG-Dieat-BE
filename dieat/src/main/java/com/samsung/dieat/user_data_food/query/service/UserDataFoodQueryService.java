package com.samsung.dieat.user_data_food.query.service;

import com.samsung.dieat.user_data_food.query.dto.ResponseUdfName;
import com.samsung.dieat.user_data_food.query.dto.ResponseUserDataFood;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.samsung.dieat.user_data_food.query.dao.UserDataFoodMapper;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;

@Service
@RequiredArgsConstructor
public class UserDataFoodQueryService {

    private final UserDataFoodMapper userDataFoodMapper;

    public UserDataFoodDTO getUserDataFoodByUdfCode(int udfCode) {
        return userDataFoodMapper.findByUdfCode(udfCode);
    }

    public List<ResponseUdfName> getUserDataFoodByLikeName(String likeName) {
        return userDataFoodMapper.findByLikeName(likeName);
    }

    public List<ResponseUserDataFood> getUserDataFoodWithNickname(String udfName) {
        return userDataFoodMapper.findByUdfNameWithNickname(udfName);
    }

}
