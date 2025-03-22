package com.samsung.dieat.open_data_food.query.dao;

import com.samsung.dieat.open_data_food.query.dto.OpenDataFoodDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpenDataFoodMapper {

    List<OpenDataFoodDto> findAll();

    OpenDataFoodDto findById(@Param("odfCode") Integer odfCode);
}
