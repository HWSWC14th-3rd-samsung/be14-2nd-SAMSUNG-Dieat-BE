package com.samsung.dieat.meal.query.dao;

import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;

import java.util.List;

public interface MealQueryRepository {

    List<MealQueryDTO> findMealsByUserCode(int userCode);

    List<String> findDistinctMealDatesByUserCode(int userCode);

    MealQueryDTO findMealByMealCodeAndUserCode(int mealCode, int userCode);
}
