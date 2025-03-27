package com.samsung.dieat.meal.query.dao;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealFoodQueryDTO;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface MealQueryMapper {

//    List<MealQueryDTO> selectAllMeals();
//
//    List<MealQueryDTO> selectMealsByUserCode(int userCode);
//
//    List<MealQueryDTO> selectMealsDefault(MealDefaultSelectCondition condition);
//
//    List<String> selectMealDatesByUserCode(int userCode);
//
//    List<String> selectMealByMealCode(int mealCode);

    // 식사 전체 조회
    List<MealQueryDTO> selectMealsByUserCode(@Param("userCode") int userCode);

    // 식사 목록 조회
    List<String> selectDistinctMealDatesByUserCode(int userCode);

    // 식사 검새
    List<MealQueryDTO> searchMeals(MealDefaultSelectCondition condition);

    // 단일 식사 조회
    MealQueryDTO selectMealByMealCodeAndUserCode(@Param("mealCode") int mealCode, @Param("userCode") int userCode);
}
