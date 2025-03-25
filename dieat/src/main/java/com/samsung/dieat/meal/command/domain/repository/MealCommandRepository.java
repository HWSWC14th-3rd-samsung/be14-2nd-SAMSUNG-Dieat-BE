package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;

import java.util.List;
import java.util.Optional;

public interface MealCommandRepository {
    void saveMealWithFoods(MealCommandVO vo);

    void deleteMealFoodByMealCode(int mealCode);

    void deleteMealByMealCode(int mealCode);


}