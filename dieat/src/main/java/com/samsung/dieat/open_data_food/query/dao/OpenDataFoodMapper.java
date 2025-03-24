package com.samsung.dieat.open_data_food.query.dao;

import com.samsung.dieat.open_data_food.query.dto.ResponseOdfName;
import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpenDataFoodMapper {

    // 전체 조회
    List<ResponseOpenDataFood> findAll();

    // 코드로 조회
    ResponseOpenDataFood findByOdfCode(@Param("odfCode") int odfCode);

    // 이름으로 조회(포함)
    List<ResponseOdfName> findByMultipleKeywords(@Param("keywords") List<String> keywords);

}