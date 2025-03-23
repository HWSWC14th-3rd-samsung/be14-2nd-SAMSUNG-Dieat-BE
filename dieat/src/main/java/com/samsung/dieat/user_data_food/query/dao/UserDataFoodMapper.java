package com.samsung.dieat.user_data_food.query.dao;

import com.samsung.dieat.user_data_food.query.dto.ResponseUdfName;
import com.samsung.dieat.user_data_food.query.dto.ResponseUserDataFood;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDataFoodMapper {
    UserDataFoodDTO findByUdfCode(int udfCode);

    List<ResponseUdfName> findByMultipleKeywords(@Param("keywords") List<String> keywords);

    List<ResponseUserDataFood> findByUdfNameWithNickname(String udfName);
}
