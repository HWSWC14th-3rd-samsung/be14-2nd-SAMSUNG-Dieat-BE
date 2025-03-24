package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;

public interface MealCommandService {

    void registerMeal(MealCommandDTO dto);
    void updateMeal(int mealCode, MealCommandDTO dto);
    void deleteMeal(int mealCode);
}