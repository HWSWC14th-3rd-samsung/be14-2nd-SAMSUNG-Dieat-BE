package com.samsung.dieat.user_data_food.query.dao;

import org.apache.ibatis.annotations.Mapper;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;

@Mapper
public interface UserDataFoodMapper {
    UserDataFoodDTO findByUdfCode(int udfCode);
}
