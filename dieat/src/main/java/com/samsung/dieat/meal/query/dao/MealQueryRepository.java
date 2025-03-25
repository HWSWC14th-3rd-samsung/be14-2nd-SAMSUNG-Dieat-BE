package com.samsung.dieat.meal.query.dao;

<<<<<<< HEAD
public interface MealQueryRepository {
=======
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;

import java.util.List;

public interface MealQueryRepository {
    List<Meal> findMealsByMealCode(int mealCode);
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}
