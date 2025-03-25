package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
<<<<<<< HEAD

public interface MealCommandService {

    void registerMeal(MealCommandDTO dto);
    void updateMeal(int mealCode, MealCommandDTO dto);
    void deleteMeal(int mealCode);
=======
import org.springframework.transaction.annotation.Transactional;

public interface MealCommandService {

    // 식사 등록
    @Transactional
    void registerMeal(int authenticatedUserCode, MealCommandDTO dto);

    // 식사 수정
    @Transactional
    void updateMeal(int authenticatedUserCode, int mealCode, MealCommandDTO dto);

    // 식사 삭제
    @Transactional
    void deleteMeal(int authenticatedUserCode, int mealCode);
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}