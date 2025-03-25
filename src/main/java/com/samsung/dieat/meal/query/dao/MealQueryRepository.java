package com.samsung.dieat.meal.query.dao;

import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;

import java.util.List;

public interface MealQueryRepository {
    List<Meal> findMealsByMealCode(int mealCode);
}
