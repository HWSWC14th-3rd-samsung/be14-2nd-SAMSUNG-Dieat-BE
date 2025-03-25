package com.samsung.dieat.meal.query.dao;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MealQueryMapper {

    List<MealQueryDTO> selectAllMeals();

    List<MealQueryDTO> selectMealsByUserCode(int userCode);

    List<MealQueryDTO> selectMealsDefault(MealDefaultSelectCondition condition);

    List<String> selectMealDatesByUserCode(int userCode);

    List<String> selectMealByMealCode(int mealCode);
}
