package com.samsung.dieat.user_data_food.query.service;

import com.samsung.dieat.user_data_food.query.dto.ResponseUdfName;
import com.samsung.dieat.user_data_food.query.dto.ResponseUserDataFood;
import java.util.Arrays;
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

    public List<ResponseUdfName> getUserDataFoodByLikeName(String keyword) {
        List<String> keywords = Arrays.asList(keyword.split("\\s+")); // 공백 기준으로 키워드 분리
        return userDataFoodMapper.findByMultipleKeywords(keywords);
    }


    public List<ResponseUserDataFood> getUserDataFoodWithNickname(String udfName) {
        return userDataFoodMapper.findByUdfNameWithNickname(udfName);
    }

}
