package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;


import java.util.List;


public interface MealQueryService {
<<<<<<< HEAD
    
=======

>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
    List<MealQueryDTO> findAllMeals();

    List<MealQueryDTO> findMealsByUserCode(int userCode);

    List<MealQueryDTO> findMealsDefault(MealDefaultSelectCondition condition);

    List<String> findMealDateListByUserCode(int userCode);

<<<<<<< HEAD
=======
    List<String> findMealByMealCode(int mealCode);
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}

