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
<<<<<<< HEAD
=======

    List<String> selectMealByMealCode(int mealCode);
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}
