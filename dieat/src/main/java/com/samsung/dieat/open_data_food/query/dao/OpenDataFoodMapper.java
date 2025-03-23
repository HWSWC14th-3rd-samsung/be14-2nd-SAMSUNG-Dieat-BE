package com.samsung.dieat.open_data_food.query.dao;

import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpenDataFoodMapper {
    List<ResponseOpenDataFood> findAll();
    ResponseOpenDataFood findByCode(@Param("code") int code);
}