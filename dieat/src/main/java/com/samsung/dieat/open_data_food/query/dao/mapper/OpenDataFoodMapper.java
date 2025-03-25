package com.samsung.dieat.open_data_food.query.dao.mapper;

import com.samsung.dieat.open_data_food.query.dto.response.ResponseOpenDataFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OpenDataFoodMapper {
    List<ResponseOpenDataFood> findAll();
    ResponseOpenDataFood findByOdfCode(Integer odfCode);
    List<ResponseOpenDataFood> findByMultipleKeywords(List<String> keywords);
}