package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;


import java.util.List;


public interface MealQueryService {
    
    List<MealQueryDTO> findAllMeals();

    List<MealQueryDTO> findMealsByUserCode(int userCode);

    List<MealQueryDTO> findMealsDefault(MealDefaultSelectCondition condition);

    List<String> findMealDateListByUserCode(int userCode);

    List<String> findMealByMealCode(int mealCode);
}

