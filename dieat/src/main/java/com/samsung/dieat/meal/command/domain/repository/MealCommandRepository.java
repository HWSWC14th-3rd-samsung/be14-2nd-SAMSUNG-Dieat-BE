package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
<<<<<<< HEAD
=======
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;

import java.util.List;
import java.util.Optional;
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49

public interface MealCommandRepository {
    void saveMealWithFoods(MealCommandVO vo);

    void deleteMealFoodByMealCode(int mealCode);

    void deleteMealByMealCode(int mealCode);
<<<<<<< HEAD
=======


>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}